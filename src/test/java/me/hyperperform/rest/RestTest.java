package me.hyperperform.rest;

import me.hyperperform.listener.GitListener;
import me.hyperperform.event.MockEvent;

import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;
import org.jboss.resteasy.mock.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.MediaType;

/**
 * Class containing JUnit tests for testing the REST component.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RestTestConfig.class)
public class RestTest
{
	/**
	 * Test for checking whether or not the GitEvents are being accepted and persisted. A mock git push event is used
	 * to carry out the test.
     */
	@Test
	public void gitEventTest() throws Exception {

		System.out.println("-------------------------------------------------");
		System.out.println("Starting REST services test");
		System.out.println("-------------------------------------------------");

		POJOResourceFactory noDef = new POJOResourceFactory(GitListener.class);
		Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();

		dispatcher.getRegistry().addResourceFactory(noDef);

		MockHttpRequest request = MockHttpRequest.post("/gitEvent");

		request.header("X-GitHub-Event", "push");
		request.contentType(MediaType.APPLICATION_JSON_TYPE);

		request.content(MockEvent.gitPushEvent.getBytes());

		MockHttpResponse response = new MockHttpResponse();
		dispatcher.invoke(request, response);

		Assert.assertEquals(response.getStatus(), 200);
	}

	/**
	 * Test to determine whether or not error codes are received if an invalid URL is accessed.
     */
	@Test
	public void invalidLinkTest() throws Exception
	{
		POJOResourceFactory noDef = new POJOResourceFactory(GitListener.class);
		Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();

		dispatcher.getRegistry().addResourceFactory(noDef);

		MockHttpRequest request = MockHttpRequest.get("/gitEvent/random");
		MockHttpResponse response = new MockHttpResponse();
		dispatcher.invoke(request, response);

		Assert.assertEquals(response.getStatus(), 404);
	}

	/**
	 * Test to check whether or not listener can handle different timezones
	 */
	@Test
	public void timezoneTest() throws Exception
	{
		POJOResourceFactory noDef = new POJOResourceFactory(GitListener.class);
		Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();

		dispatcher.getRegistry().addResourceFactory(noDef);

		MockHttpRequest request = MockHttpRequest.post("/gitEvent");

		request.header("X-GitHub-Event", "push");
		request.contentType(MediaType.APPLICATION_JSON_TYPE);

		request.content(MockEvent.alternativeGitPush.getBytes());

		MockHttpResponse response = new MockHttpResponse();
		dispatcher.invoke(request, response);

		Assert.assertEquals(response.getStatus(), 200);
	}
}