package me.hyperperform.event;

import me.hyperperform.event.Calendar.AttendeeState;
import me.hyperperform.event.Calendar.CalendarMeeting;
import me.hyperperform.event.Calendar.CalendarProject;

import org.junit.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * hyperperform-system
 * Group: CodusMaximus
 * Date: 2016/07/22
 * Feature: CalendarTest
 */
public class CalendarPersistenceTest
{
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;
    private CalendarMeeting cm;
    private CalendarProject cp;
    private Map<String, AttendeeState> arr;


    @Before
    public void init()
    {
        System.out.println("-------------------------------------------------");
        System.out.println("Starting Calendar Persistence Test");
        System.out.println("-------------------------------------------------");
        entityManagerFactory = Persistence.createEntityManagerFactory("PostgreJPA");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();


        arr = new HashMap<String, AttendeeState>();
        arr.put("Avi", AttendeeState.ACCEPTED);
        arr.put("Rohan", AttendeeState.DECLINED);
        arr.put("Jason", AttendeeState.ACCEPTED);
        arr.put("Claudio", AttendeeState.DECLINED);

        ArrayList<String> tmp = new ArrayList<String>();
        tmp.add("Avinash");
        tmp.add("Jason");
        tmp.add("Rohan");

        cm = new CalendarMeeting(UUID.randomUUID().toString(), "5", "hyperperformteam@gmail.com", "2007-09-23 10:10:10.0", "SA", arr, "2008-09-23 10:10:10.0");
        cp = new CalendarProject(UUID.randomUUID().toString(), "5", "hyperperformteam@gmail.com", "2007-09-23 10:10:10.0", "CodusMaximus", tmp, "2008-09-23 10:10:10.0");
    }

    @Test
    public void jpaTest()
    {
        System.out.print("Starting Calendar jpaTest ...");
        entityTransaction.begin();

        entityManager.persist(cm);
        entityManager.persist(cp);

        entityTransaction.commit();

    }

    @Test
    public void QueryTest()
    {
        System.out.print("Starting CalendarMeeting & CalendarProject QueryTest ...");
        entityTransaction.begin();

        entityManager.persist(cm);
        entityManager.persist(cp);

        entityTransaction.commit();

        Query query = entityManager.createQuery("FROM CalendarMeeting ", CalendarMeeting.class);
        List<CalendarMeeting> result = query.getResultList();

        Assert.assertNotEquals("No Elements", result.size(), 0);
        Assert.assertEquals("CalenderID don't match", cm.getCalendarID(), result.get(result.size()-1).getCalendarID());
        Assert.assertEquals("Creators don't match", cm.getCreator(), result.get(result.size()-1).getCreator());
        Assert.assertEquals("EventID don't match", cm.getEventID(), result.get(result.size()-1).getEventID());
        Assert.assertEquals("Attendees don't match", cm.getAttendees(), result.get(result.size()-1).getAttendees());
        Assert.assertEquals("CalanderID don't match", cm.getCalendarID(), result.get(result.size()-1).getCalendarID());
        Assert.assertEquals("Location don't match", cm.getLocation(), result.get(result.size()-1).getLocation());
        Assert.assertEquals("DueDate don't match", cm.getDueDate(), result.get(result.size()-1).getDueDate());
        Assert.assertEquals("Timestamp don't match", cm.getTimestamp(), result.get(result.size()-1).getTimestamp());


        query = entityManager.createQuery("FROM CalendarProject ", CalendarProject.class);
        List<CalendarProject> res = query.getResultList();
        Assert.assertNotEquals("No Elements", res.size(), 0);
        Assert.assertEquals("EventID don't match", cp.getEventID(), res.get(res.size()-1).getEventID());
        Assert.assertEquals("Creators don't match", cp.getCreator(), res.get(res.size()-1).getCreator());
        Assert.assertEquals("EventID don't match", cp.getCreator(), res.get(res.size()-1).getCreator());
        Assert.assertEquals("Collaborators don't match", cp.getCollaborators(), res.get(res.size()-1).getCollaborators());
        Assert.assertEquals("CalanderID don't match", cp.getCalendarID(), res.get(res.size()-1).getCalendarID());
        Assert.assertEquals("RepoName don't match", cp.getRepoName(), res.get(res.size()-1).getRepoName());
        Assert.assertEquals("DueDate don't match", cp.getDueDate(), res.get(res.size()-1).getDueDate());
        Assert.assertEquals("Timestamp don't match", cp.getTimestamp(), res.get(res.size()-1).getTimestamp());

    }


    @After
    public void closeManager()
    {
        entityManager.close();
        entityManagerFactory.close();
        System.out.println("\t\tSUCCESS\n\n");

    }
}
