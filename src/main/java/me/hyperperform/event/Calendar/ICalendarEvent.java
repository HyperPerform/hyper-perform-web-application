package me.hyperperform.event.Calendar;

import me.hyperperform.event.IEvent;
import java.sql.Timestamp;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/06
 * Feature: Calendar
 */

public interface ICalendarEvent extends IEvent
{

    public String getEventID();

    public void setEventID(String eventID);

    public String getCalendarID();

    public void setCreator(String creator);

    public String getCreator();

    public void setCalendarID(String calendarID);

    public Timestamp getDueDate();

    public void setDueDate(Timestamp dueDate);

    public void setDate(Timestamp timestamp);
}