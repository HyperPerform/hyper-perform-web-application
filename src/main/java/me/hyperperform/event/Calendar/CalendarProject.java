package me.hyperperform.event.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/06
 * Feature: Calendar
 */

@Entity
@Table(name = "\"CalendarProject\"")

public class CalendarProject implements ICalendarEvent
{
    @Id
    private String eventID;

    private String calendarID;
    private Timestamp dueDate;
    private String repoName;
    private String[] collaborators;
    private Timestamp timestamp;

    public CalendarProject()
    {

    }

    public CalendarProject(String eventID, String calendarID, Timestamp dueDate, String repoName, String[] collaborators, Timestamp timestamp)
    {
        setEventID(eventID);
        setCalendarID(calendarID);
        setDueDate(dueDate);
        setRepoName(repoName);
        setCollaborators(collaborators);
        setTimestamp(timestamp);

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

    public String[] getCollaborators()
    {
        return collaborators;
    }

    public void setCollaborators(String[] collabs)
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
}
