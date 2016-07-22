package me.hyperperform.event.Calendar;

import java.sql.Timestamp;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/06
 * Feature: Calendar
 */

//@Entity
//@Table
public class CalendarProject implements ICalendarEvent
{

    private String eventID;
    private String calendarID;
    private Timestamp dueDate;
    private String repoName;
    private String[] collaborators;
    private Timestamp timestamp;

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
