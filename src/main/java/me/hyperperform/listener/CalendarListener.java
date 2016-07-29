package me.hyperperform.listener;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

import me.hyperperform.event.Calendar.AttendeeState;
import me.hyperperform.event.Calendar.CalendarMeeting;
import me.hyperperform.event.Calendar.CalendarProject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.*;

/**
 * Hyper-perform
 * Group: CodusMaximus
 * Date: 2016/07/24
 * Feature: Calendar Listener
 */

@Path("/calendar")
public class CalendarListener implements IListener
{
    @GET
    @Consumes("application/json")
    public Response listen(@HeaderParam("X-Goog-Resource-URI") String link, String jsonStr) throws Exception
    {
       try
       {
           JSONObject json = (JSONObject) new JSONParser().parse(jsonStr);
           JSONArray items = (JSONArray) json.get("items");
           Iterator<JSONObject> iterator = items.iterator();

           while (iterator.hasNext())
           {
               JSONObject item = iterator.next();
               if (item.get("kind").equals("calendar#event"))
               {
                   JSONObject crt = (JSONObject) item.get("creator");
                   JSONObject start = (JSONObject) item.get("start");
                   JSONArray attendees = (JSONArray) item.get("attendees");

                   String eID = ((String) item.get("htmlLink")).split(".eid=")[1];
                   String creator = (String) crt.get("email");
                   String cID = link.split("/calendars/")[1].split("/")[0];
                   String due = (String) start.get("dateTime");

                   if(due == null)
                   {
                       due = (String) start.get("date");
                   }

                   String location = (String) item.get("location");
                   String timeCreated = (String) item.get("created");

//                   if(location == null)
//                   {
                       String summary = ((String) item.get("summary")).toLowerCase();
                       int ind = summary.indexOf("@reponame");
//                   }

                   if(location == null && ind != -1)
                   {
                       String repoName = summary.substring(0, ind);
                       ArrayList<String> collaborators = new ArrayList<String>();
                       for (int i = 0; i < attendees.size(); i++)
                       {
                           collaborators.add((String) ((JSONObject) attendees.iterator().next()).get("email"));
                       }

                       CalendarProject calProject = new CalendarProject(eID, cID, creator, (extractDate(due) + " " + extractTime(due)),
                               repoName, collaborators, extractDate(timeCreated) + " " + extractTime(timeCreated));
                   }
                   else
                   {
                       Map<String, AttendeeState> attendeeMap = new HashMap<String, AttendeeState>();

                       if(attendees != null)
                       {
                           Iterator<JSONObject> iterate = attendees.iterator();
                           while (iterate.hasNext())
                           {
                               JSONObject attend = iterate.next();
                               String tmp = (String) attend.get("responseStatus");
                               AttendeeState as;
                               if (tmp.equals("accepted"))
                               {
                                   as = AttendeeState.ACCEPTED;
                               }
                               else if (tmp.equals("declined"))
                               {
                                   as = AttendeeState.DECLINED;
                               }
                               else if (tmp.equals("tentative"))
                               {
                                   as = AttendeeState.TENTATIVE;
                               }
                               else if (tmp.equals("needsAction"))
                               {
                                   as = AttendeeState.NEEDSACTION;
                               }
                               else
                               {
                                   as = AttendeeState.NEEDSACTION;
                               }

                               attendeeMap.put((String) attend.get("email"), as);
                           }
                       }

                       CalendarMeeting calMeeting = new CalendarMeeting(eID, cID, creator, extractDate(due) + " " + extractTime(due),
                               location, attendeeMap, extractDate(timeCreated) + " " + extractTime(timeCreated));
                   }
               }
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
        return Response.status(200).entity("Successfully received events").header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/testing")
    public Response myTest() throws Exception
    {
        return Response.status(200).entity("Testing").build();
    }

    static <T> void log(T t)
    {
        System.out.println(t);
    }

    private String extractDate(String s)
    {
        if(s == null)
            return null;

        return (s.indexOf('T') != -1 ? s.substring(0, s.indexOf('T')) : s);
    }

    private String extractTime(String s)
    {
        if(s == null)
            return "";

        String tmp = s;
        tmp = s.substring(s.indexOf('T')+1);

        if(tmp.equals(s))
        {
            System.out.println();
            return "00:00:01";
        }

        if (tmp.indexOf('-') != -1)
            tmp = tmp.substring(0, tmp.indexOf('-'));
        else if (tmp.indexOf('+') != -1)
            tmp = tmp.substring(0, tmp.indexOf('+'));
        else if (tmp.indexOf('.') != -1)
            tmp = tmp.substring(0, tmp.indexOf('.'));

        return tmp;
    }
}