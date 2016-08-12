package me.hyperperform.rest;

import me.hyperperform.reporting.ReportGenerator;
import me.hyperperform.reporting.request.*;
import me.hyperperform.reporting.response.*;

import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by rohan on 2016/08/10.
 */

@Path("/report")
public class ReportingRest {

    @Inject
    ReportGenerator reportGenerator;

    @GET
//    @Consumes("application/json")
//    public Response getSummary(GetSummaryRequest getSummaryRequest)
    @Produces("application/json")
    public Response getSummary()
    {
        GetSummaryRequest getSummaryRequest = new GetSummaryRequest();
        getSummaryRequest.setName("Sven Fuchs");
        getSummaryRequest.setStartDate("2015-05-05 10:00:00");
        getSummaryRequest.setEndDate("2015-05-05 23:00:00");

        GetSummaryResponse getSummaryResponse = reportGenerator.getSummary(getSummaryRequest);

        return Response.status(200).entity(getSummaryResponse).build();
    }
}
