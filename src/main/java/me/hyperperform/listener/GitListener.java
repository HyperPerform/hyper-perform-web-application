package me.hyperperform.listener;

import me.hyperperform.QueueConnection;
import me.hyperperform.event.Git.GitPush;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.inject.Inject;

import javax.persistence.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/05
 * Feature: Github Listener
 *
 * Provides a URL for GitHub to push events to. From here the events are persisted and placed onto a queue
 * for CEP at a later stage.
 */

@Path("/gitEvent")
public class GitListener implements IListener
{
    /**
     * Connection to the messaging queue. The object is provided through dependency injection.
     */
    @Inject
    QueueConnection queueConnection;

    /**
     * Persistence context which allows for persisting the events received.
     */
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;

    @PostConstruct
    private void initConnection()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("PostgreJPA");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @PreDestroy
    private void disconnect()
    {
        entityManager.close();
        entityManagerFactory.close();
    }

    /**
     *
     * @param eventType This field identifies the type of GitHub event coming through i.e push, pull, issue closed etc.
     * @param jsonStr Contains the actual information about the event. This JSON object is processed and persisted.
     * @return If the persistence was successful a 200 status code is returned.
     */
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

            if (queueConnection != null)
                queueConnection.sendObject(push);

            if (entityManager != null)
            {
                entityManager.getTransaction().begin();

                entityManager.persist(push);

                entityManager.getTransaction().commit();
            }
        }

        return Response.status(200).entity("Successfully received event").header("Access-Control-Allow-Origin", "*").build();
    }



//    @GET
//    @Path("/testing")
//    public Response myTest() throws Exception
//    {
//        GitPush gitPush = new GitPush();
//
//        String out = "---Start Debug Output--- <br/>";
//
//        out += "Sending git event object to queue <br/>";
//        queueConnection.sendObject(gitPush);
//
//        out += "Getting object from queue <br/>";
//        out += ((GitPush) queueConnection.receive()).toString() + "<br/>";
//
//        out += "Persistence Context: " + em + "<br/>";
//
//        out += "---End Debug Output--- <br/>";
//
//        return Response.status(200).entity(out).build();
//    }

    private static <T> void log(T t)
    {
        System.out.println(t);
    }

    /**
     * Accepts timestamp as a String. Github event timestamp is not of correct format thus this method has the
     *          ability to extract the date component of the timestamp.
     * @param s Timestamp of the event as a String object.
     * @return Returns the date of the timestamp as a String.
     */
    private String extractDate(String s)
    {
        return (s.indexOf('T') != -1) ? s.substring(0, s.indexOf('T')) : s.substring(0, s.indexOf(' '));
    }

    /**
     *  Extracts the time portion from the timestamp.
     * @param s Timestamp of the event as a String object.
     * @return Returns the time of the timestamp as a String.
     */
    private String extractTime(String s)
    {
        String tmp = s;
        tmp = s.substring(s.indexOf('T')+1);

        if (tmp.indexOf('-') != -1)
            tmp = tmp.substring(0, tmp.indexOf('-'));
        else
        if (tmp.indexOf('+') != -1)
            tmp = tmp.substring(0, tmp.indexOf('+'));

        return tmp;
    }
}
