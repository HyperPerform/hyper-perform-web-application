package me.hyperperform.listener;


import me.hyperperform.event.Git.GitPush;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;
import javax.inject.Inject;


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
    GitPush g;

    @POST
    @Consumes("application/json")
    public Response listen(@HeaderParam("X-GitHub-Event") String eventType, String jsonStr) throws ParseException
    {

        JSONObject json = (JSONObject)new JSONParser().parse(jsonStr);


        System.out.println("Received " + eventType + " event!");

        if (eventType.equals("push"))
        {
           JSONObject repository = (JSONObject)json.get("repository");
           JSONObject commit = (JSONObject)json.get("head_commit");
           JSONObject pusher = (JSONObject)json.get("pusher");

           String name = (String)repository.get("full_name");
           String date = (String)commit.get("timestamp");
           String user = (String)pusher.get("name");

           GitPush push = new GitPush(name, extractDate(date) + " " + extractTime(date), user);
           log(push);
        }

        return Response.status(200).entity("Successfully received event").header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/testing")
    public Response myTest()
    {
        return Response.status(200).entity("Wow"+g.toString()).build();
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
