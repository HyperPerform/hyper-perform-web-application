package me.hyperperform.rest;

import me.hyperperform.listener.GitListener;
import me.hyperperform.event.MockEvent;
import me.hyperperform.event.Git.GitPush;

import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;
import org.jboss.resteasy.mock.*;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import javax.persistence.*;

public class RestTest
{
	@Test
	@Ignore
	public void simpleTest() throws Exception {

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

//		System.out.println("-------------------------------------------------");
//		System.out.println(response.getContentAsString());
//		System.out.println(response.getStatus());
//		System.out.println("-------------------------------------------------");

		Assert.assertEquals(response.getStatus(), 200);
	}
}