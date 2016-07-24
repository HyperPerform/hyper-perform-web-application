package me.hyperperform.listener;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

import me.hyperperform.event.Calendar.CalendarMeeting;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;

@Path("/calendar")
public class CalendarListener implements IListener
{
    @GET
    @Consumes("application/json")
    public Response listen(@HeaderParam("X-Goog-Resource-URI") String link, String jsonStr) throws ParseException
    {

        System.out.println("Received response from " + link);

        JSONObject json = (JSONObject)new JSONParser().parse(jsonStr);

        JSONArray items = (JSONArray)json.get("items");
        Iterator<JSONObject> iterator = items.iterator();

        while(iterator.hasNext())
        {
            JSONObject item = iterator.next();
            if (((JSONObject) item.get("kind")).toString().equals("calendar#event"))
            {
                JSONObject crt = (JSONObject) item.get("creator");
                JSONObject start = (JSONObject) item.get("start");
                JSONArray attendees = (JSONArray) item.get("attendees");

                String eID = (String) item.get("htmlLink");
                String creator = (String) crt.get("email");
                String cID = link.split("/calendars/")[1].split("/")[0];
                String due = (String) start.get("dateTime");
                String location = (String) item.get("location");
                ArrayList<String> attendeeEmail = new ArrayList<String>();

                Iterator<String> iterate = attendees.iterator();
                while (iterate.hasNext())
                {
                    attendeeEmail.add(iterate.next());
                }

                String timeCreated = (String) item.get("created");

                CalendarMeeting calMeeting = new CalendarMeeting();
            }
        }

        return Response.status(200).entity("Successfully received events").header("Access-Control-Allow-Origin", "*").build();
    }
}