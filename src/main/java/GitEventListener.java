// import javax.ws.rs.Consumes;
// import javax.ws.rs.DELETE;
// import javax.ws.rs.GET;
// import javax.ws.rs.POST;
// import javax.ws.rs.Path;
// import javax.ws.rs.PathParam;
// import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
// import javax.ws.rs.HeaderParam;

import javax.ws.rs.*;

@Path("/gitEvent")
public class GitEventListener
{	
	@POST
	@Consumes("application/json")
	public Response listen(@HeaderParam("X-GitHub-Event") String eventType, String jsonStr) 
	{	
		System.out.println("Recieved " + eventType + " event!");

		System.out.println(jsonStr);

		return Response.status(200).entity("").header("Access-Control-Allow-Origin", "*").build();

		// System.out.println("=================Recieved Request!!!!=================");
		// return emps.get(id);
		// return Response.status(200).entity("Hello World!").build();
		// return "Hello World!";
	}
}