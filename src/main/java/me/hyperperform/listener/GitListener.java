package me.hyperperform.listener;

import me.hyperperform.QueueConnection;
import me.hyperperform.event.Git.GitPush;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;


/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/05
 * Feature: Github Listener
 */

@Path("/gitEvent")
public class GitListener implements IListener
{
    @Inject
    QueueConnection queueConnection;

    @PersistenceContext
    EntityManager em;

    @POST
    @Consumes("application/json")
    public Response listen(@HeaderParam("X-GitHub-Event") String eventType, String jsonStr) throws Exception
    {
        JSONObject json = (JSONObject)new JSONParser().parse(jsonStr);

        if (eventType.equals("push"))
        {
           JSONObject repository = (JSONObject)json.get("repository");
           JSONObject commit = (JSONObject)json.get("head_commit");
           JSONObject pusher = (JSONObject)json.get("pusher");

           String name = (String)repository.get("full_name");
           String date = (String)commit.get("timestamp");
           String user = (String)pusher.get("name");

           GitPush push = new GitPush(name, extractDate(date) + " " + extractTime(date), user);

            log("------- " + queueConnection + "-------");
        }

        return Response.status(200).entity("Successfully received event").header("Access-Control-Allow-Origin", "*").build();
    }



    @GET
    @Path("/testing")
    public Response myTest() throws Exception
    {
        GitPush gitPush = new GitPush();
        
        String out = "---Start Debug Output--- <br/>";
        
        out += "Sending git event object to queue <br/>";
        queueConnection.sendObject(gitPush);

        out += "Getting object from queue <br/>";
        out += ((GitPush) queueConnection.receive()).toString() + "<br/>";

        out += "Persistence Context: " + em + "<br/>";

        out += "---End Debug Output--- <br/>";

        return Response.status(200).entity(out).build();
    }

    static <T> void log(T t)
    {
        System.out.println(t);
    }

    private String extractDate(String s)
    {
        return (s.indexOf('T') != -1) ? s.substring(0, s.indexOf('T')) : s.substring(0, s.indexOf(' '));
    }

    private String extractTime(String s)
    {
        String tmp = s;
        tmp = s.substring(s.indexOf('T')+1);

        if (tmp.indexOf('-') != -1)
            tmp = tmp.substring(0, tmp.indexOf('-'));

        return tmp;
    }
}
