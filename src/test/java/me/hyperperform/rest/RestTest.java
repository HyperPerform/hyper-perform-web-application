package me.hyperperform.rest;

import me.hyperperform.listener.GitListener;
import me.hyperperform.listener.CalendarListener;
import me.hyperperform.event.MockEvent;

import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;
import org.jboss.resteasy.mock.*;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

public class RestTest
{
	@Test
	@Ignore
	public void simpleTest() throws Exception {

		System.out.println("-------------------------------------------------");
		System.out.println("Starting REST services test - Git push");
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

	@Test
	public void calendarSimpleTest() throws Exception
	{
		System.out.println("-------------------------------------------------");
		System.out.println("Starting REST services test - Calendar");
		System.out.println("-------------------------------------------------");

		POJOResourceFactory noDef = new POJOResourceFactory(CalendarListener.class);
		Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();

		dispatcher.getRegistry().addResourceFactory(noDef);

		MockHttpRequest request = MockHttpRequest.get("/calendar");

		request.header("X-Goog-Resource-URI", "https://www.googleapis.com/calendar/v3/calendars/hk3487gd7h57oh9g71he9tfjs0@group.calendar.google.com/events");
		request.contentType(MediaType.APPLICATION_JSON_TYPE);

		request.content(MockEvent.calendarEvents.getBytes());

		MockHttpResponse response = new MockHttpResponse();
		dispatcher.invoke(request, response);

		Assert.assertEquals(response.getStatus(), 200);
	}
}