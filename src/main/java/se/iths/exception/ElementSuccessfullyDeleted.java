package se.iths.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ElementSuccessfullyDeleted extends WebApplicationException {
    public ElementSuccessfullyDeleted(String message) {
        super(Response.ok().entity("The element with Name / Id : ["+message+"] is successfully deleted!").type(MediaType.TEXT_PLAIN_TYPE).build());
    }
}
