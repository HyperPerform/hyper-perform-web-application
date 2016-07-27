package me.hyperperform.listener;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by rohan on 2016/07/27.
 */

@Provider
public class ListenerExceptionMapper implements ExceptionMapper<NotFoundException> {

    public Response toResponse(NotFoundException e) {
        return Response.status(404).entity("Invalid url").build();
    }
}
