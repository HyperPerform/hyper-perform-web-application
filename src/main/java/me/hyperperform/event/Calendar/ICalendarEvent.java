package me.hyperperform.event.Calendar;

import me.hyperperform.event.Event;
import java.sql.Timestamp;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/06
 * Feature: Calendar
 */

public interface ICalendarEvent extends Event
{

    public String getEventID();

    public void setEventID(String eventID);

    public String getCalendarID();

    public void setCalendarID(String calendarID);

    public Timestamp getDueDate();

    public void setDueDate(Timestamp dueDate);

    public void setDate(Timestamp timestamp);
}