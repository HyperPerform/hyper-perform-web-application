package me.hyperperform.event.Git;

import me.hyperperform.event.EventListener;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/gitEvent")
public class GitEventListener implements EventListener
{	
	@POST
	@Consumes("application/json")
	public Response listen(@HeaderParam("X-GitHub-Event") String eventType, String jsonStr) 
	{	
		System.out.println("Recieved " + eventType + " event!");
		System.out.println(jsonStr);

		return Response.status(200).entity("").header("Access-Control-Allow-Origin", "*").build();
	}
}