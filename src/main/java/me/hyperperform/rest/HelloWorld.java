package me.hyperperform.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/demo")
public class HelloWorld
{	
	@GET
	public Response foo() 
	{	
		return Response.status(200).entity("Hello World!").build();
	}
}