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
public class CalendarProject extends CalendarEvent
{
    private String repoName;
    private String[] collaborators;

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

    @Override
    public String getEventID()
    {
        return eventID;
    }

    @Override
    public void setEventID(String eID)
    {
        eventID = eID;
    }

    @Override
    public String getCalendarID()
    {
        return calendarID;
    }

    @Override
    public void setCalendarID(String cID)
    {
        calendarID = cID;
    }

    @Override
    public Timestamp getDueDate()
    {
        return dueDate;
    }

    @Override
    public void setDueDate(Timestamp dDate)
    {
        dueDate = dDate;
    }

    @Override
    public void setDate(Timestamp timestamp)
    {
        super.setDate(timestamp);
    }
}
