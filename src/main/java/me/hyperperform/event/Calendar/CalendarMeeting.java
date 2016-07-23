package me.hyperperform.event.Calendar;

import javax.persistence.Column;
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
    @Column(name = "eventID")
    private String eventID;

    @Column(name = "calendarID")
    private String calendarID;

    @Column(name = "duedate")
    private Timestamp dueDate;

    @Column(name = "location")
    private String location;

    @Column(name = "attendees")
    private String[] attendees;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public CalendarMeeting()
    {

    }

    public CalendarMeeting(String eventID, String calendarID, Timestamp dueDate, String location, String[] attendees, Timestamp timestamp)
    {
        setEventID(eventID);
        setCalendarID(calendarID);
        setDueDate(dueDate);
        setLocation(location);
        setAttendees(attendees);
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
