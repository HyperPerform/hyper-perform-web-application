package me.hyperperform.listener;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Allows for intercepting exceptions that occur through REST api. Intercepted exceptions can be handled appropriately.
 */

@Provider
public class ListenerExceptionMapper implements ExceptionMapper<Exception> {

    /**
     *
     * @param e Exception that was intercepted.
     * @return  Returns appropriate response code with regards to exception type. E.g NotFoundException returns 404.
     */
    public Response toResponse(Exception e) {
        return Response.status(404).entity("Invalid url").build();
    }
}
