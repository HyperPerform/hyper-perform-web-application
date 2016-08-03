package me.hyperperform.listener;

import me.hyperperform.QueueConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.inject.Inject;

import javax.persistence.*;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by rohan on 2016/08/02.
 */
@Path("/TravisEvent")
public class TravisListener implements IListener
{

    @Inject
    QueueConnection queueConnection;

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

    @POST
    @Consumes("application/json")
    public Response listen(String jsonStr) throws Exception
    {
        log(jsonStr);
//        JSONObject json = (JSONObject)new JSONParser().parse(jsonStr);

//        if (eventType.equals("push"))
//        {
//            JSONObject repository = (JSONObject)json.get("repository");
//            JSONObject commit = (JSONObject)json.get("head_commit");
//            JSONObject pusher = (JSONObject)json.get("pusher");
//
//            String name = (String)repository.get("full_name");
//            String date = (String)commit.get("timestamp");
//            String user = (String)pusher.get("name");
//
//            GitPush push = new GitPush(name, extractDate(date) + " " + extractTime(date), user);
//
//            if (queueConnection != null)
//                queueConnection.sendObject(push);
//
//            if (entityManager != null)
//            {
//                entityManager.getTransaction().begin();
//
//                entityManager.persist(push);
//
//                entityManager.getTransaction().commit();
//            }
//        }

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
}
