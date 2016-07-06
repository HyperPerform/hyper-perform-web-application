package me.hyperperform.event.Calendar;

import me.hyperperform.event.Event;
import java.sql.Timestamp;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/06
 * Feature: Calendar
 */

public abstract class CalendarEvent extends Event
{
    protected String eventID = "";
    protected String calendarID = "";
    protected Timestamp dueDate = null;

    public abstract String getEventID();

    public abstract void setEventID(String eventID);

    public abstract String getCalendarID();

    public abstract void setCalendarID(String calendarID);

    public abstract Timestamp getDueDate();

    public abstract void setDueDate(Timestamp dueDate);

    public void setDate(Timestamp timestamp)
    {
        time = timestamp;
    }
}