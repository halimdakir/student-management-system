package se.iths.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ElementNotFoundException extends WebApplicationException {

    public ElementNotFoundException(String message) {
        super(Response.status(Response.Status.NOT_FOUND).entity("This NAME / ID ["+message+"] does not exist!").type(MediaType.TEXT_PLAIN_TYPE).build());
    }
}
