package me.hyperperform.listener;

import me.hyperperform.QueueConnection;

import me.hyperperform.event.Travis.TravisEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.inject.Inject;

import javax.persistence.*;

import javax.ws.rs.core.MultivaluedMap;
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
    @Consumes("application/x-www-form-urlencoded")
    public Response listen(MultivaluedMap<String, String> content) throws Exception {

        TravisEvent t = new TravisEvent();

        t.setCommiter(content.get("committer_name").get(0));
        t.setBranch(content.get("branch").get(0));
        t.setStatus(content.get("status_message").get(0));
        t.setTimestamp(content.get("Started_at").get(0));
        t.setRepo(content.get("repository").get(0));

        log(t);

//        log(content.toString());
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

    private static <T> void log(T t)
    {
        System.out.println(t);
    }
}
