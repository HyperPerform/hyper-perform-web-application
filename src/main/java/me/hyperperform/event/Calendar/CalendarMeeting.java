package me.hyperperform.event.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/06
 * Feature: Calendar
 */


@Entity
@Table(name = "\"CalendarMeeting\"")
public class CalendarMeeting implements ICalendarEvent
{
    @Id
    private String eventID;

    private String calendarID;
    private Timestamp dueDate;
    private String location;
    private String[] attendees;
    private Timestamp timestamp;

    public CalendarMeeting()
    {

    }

    public CalendarMeeting(String eventID, String calendarID, Timestamp dueDate, String location, String[] attendees, Timestamp timestamp)
    {
        this.eventID = eventID;
        this.calendarID = calendarID;
        this.dueDate = dueDate;
        this.location = location;
        this.attendees = attendees;
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp)
    {
        this.timestamp = timestamp;
    }
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
