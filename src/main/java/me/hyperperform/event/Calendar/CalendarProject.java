package me.hyperperform.event.Calendar;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/06
 * Feature: Calendar
 */

@Entity
@Table(name = "\"CalendarProject\"")
public class CalendarProject implements ICalendarEvent, Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "projectID")
    private int id;


    //    @Id
    @Column(name = "eventID")
    private String eventID;

    @Column(name = "creator")
    private String creator;

    @Column(name = "calendarID")
    private String calendarID;

    @Column(name = "duedate")
    private Timestamp dueDate;

    @Column(name = "reponame")
    private String repoName;

//    @ElementCollection
    @Column(name = "collaborators")
    private ArrayList<String> collaborators;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public CalendarProject()
    {

    }

    public CalendarProject(String eventID, String calendarID, String create, String due, String repoName, ArrayList<String> collaborators, String time)
    {
        setEventID(eventID);
        setCalendarID(calendarID);
        setCreator(create);
        if(due.equals(null))
            setDueDate(null);
        else
            setDueDate(Timestamp.valueOf(due));

        setRepoName(repoName);
        setCollaborators(collaborators);
        setTimestamp(Timestamp.valueOf(time));

    }
    public Timestamp getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getRepoName()
    {
        return repoName;
    }

    public void setRepoName(String rName)
    {
        repoName = rName;
    }

    public ArrayList<String> getCollaborators()
    {
        return collaborators;
    }

    public void setCollaborators(ArrayList<String> collabs)
    {
        collaborators = collabs;
    }

    public String getEventID()
    {
        return eventID;
    }

    public void setEventID(String eID)
    {
        eventID = eID;
    }

    public String getCalendarID()
    {
        return calendarID;
    }

    public void setCalendarID(String cID)
    {
        calendarID = cID;
    }

    public Timestamp getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(Timestamp dDate)
    {
        dueDate = dDate;
    }

    public void setDate(Timestamp timestamp)
    {
       this.timestamp = timestamp;
    }

    public String getCreator()
    {
        return creator;
    }

    public void setCreator(String creator)
    {
        this.creator = creator;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
