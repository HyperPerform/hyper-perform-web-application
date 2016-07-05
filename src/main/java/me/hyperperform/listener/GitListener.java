package me.hyperperform.listener;


import me.hyperperform.event.Event;
import me.hyperperform.event.Git.GitEvent;

import me.hyperperform.event.Git.GitPush;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.*;


/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/05
 * Feature: Github Listener
 */

public class GitListener implements IListener
{

    @Path("/gitEvent")
    public class GitEventListener implements IListener
    {
        @POST
        @Consumes("application/json")
        public Response listen(@HeaderParam("X-GitHub-Event") String eventType, String jsonStr) throws ParseException
        {

            JSONObject json = (JSONObject)new JSONParser().parse(jsonStr);


            System.out.println("Received " + eventType + " event!");

            if (eventType.equals("push"))
            {
                GitPush push = new GitPush();
                JSONObject n = (JSONObject) json.get("repository");
                JSONObject d = (JSONObject) json.get("head_commit");
                JSONObject u = (JSONObject) json.get("pusher");
                String name = "" + n.get("full_name");
                String date = "" + d.get("timestamp");
                String user = "" + u.get("name");

                push.CreatePushEvent(name, date, user);
            }


            System.out.println(jsonStr);

            return Response.status(200).entity("").header("Access-Control-Allow-Origin", "*").build();
        }
    }

}
