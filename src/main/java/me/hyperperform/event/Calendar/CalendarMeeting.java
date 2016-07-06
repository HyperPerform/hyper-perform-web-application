package me.hyperperform.event.Calendar;

import java.sql.Timestamp;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/06
 * Feature: Calendar
 */

public class CalendarMeeting extends CalendarEvent
{
    private String location;
    private String[] attendees;

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String loc)
    {
        location = loc;
    }

    public String[] getAttendees()
    {
        return attendees;
    }

    public void setAttendees(String[] attend)
    {
        attendees = attend;
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
