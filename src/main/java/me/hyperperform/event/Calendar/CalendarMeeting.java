package me.hyperperform.event.Calendar;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "attendees")
//    @ElementCollection
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @OneToMany(fetch = FetchType.EAGER)
    private ArrayList<String> attendees;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public CalendarMeeting()
    {

    }

    public CalendarMeeting(String eventID, String calendarID, String creator, String dueDate, String location, ArrayList<String> attendees, String timestamp)
    {
        setEventID(eventID);
        setCalendarID(calendarID);
        setCreator(creator);
        setDueDate(Timestamp.valueOf(dueDate));
        setLocation(location);
        setAttendees(attendees);
        setTimestamp(Timestamp.valueOf(timestamp));
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

    public List<String> getAttendees()
    {
        return attendees;
    }

    public void setAttendees(ArrayList<String> attend)
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
