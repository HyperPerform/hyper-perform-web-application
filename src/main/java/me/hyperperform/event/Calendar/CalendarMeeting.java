package me.hyperperform.event.Calendar;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/06
 * Feature: Calendar
 */


@Entity
@Table(name = "\"CalendarMeeting\"")
public class CalendarMeeting implements ICalendarEvent, Serializable
{
    @Id
    @Column(name = "eventID")
    private String eventID;

    @Column(name = "creator")
    private String creator;

    @Column(name = "calendarID")
    private String calendarID;

    @Column(name = "duedate")
    private Timestamp dueDate;

    @Column(name = "location")
    private String location;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "attendees")
//    @ManyToMany(cascade = CascadeType.ALL)
    private Map<String, AttendeeState> attendees;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public CalendarMeeting()
    {

    }

    public CalendarMeeting(String eventID, String calendarID, String creator, String due, String location, Map<String, AttendeeState> attendees, String time)
    {
        setEventID(eventID);
        setCalendarID(calendarID);
        setCreator(creator);
        if(due.equals(null))
            setDueDate(null);
        else
            setDueDate(Timestamp.valueOf(due));
        setLocation(location);
        setAttendees(attendees);
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
    public String getLocation()
    {
        return location;
    }

    public void setLocation(String loc)
    {
        location = loc;
    }

    public String getCreator()
    {
        return creator;
    }

    public void setCreator(String creator)
    {
        this.creator = creator;
    }

    public Map<String, AttendeeState> getAttendees()
    {
        return attendees;
    }

    public void setAttendees(Map<String, AttendeeState> attend)
    {
        attendees = new HashMap<String, AttendeeState>();

        attendees.putAll(attend);
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
