import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/demo")
public class HelloRest
{	
	@GET
	public Response getDemo() 
	{
		// return emps.get(id);
		return Response.status(200).entity("Hello World!").build();
		// return "Hello World!";
	}
}