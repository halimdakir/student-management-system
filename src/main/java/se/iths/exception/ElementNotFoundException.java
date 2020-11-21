package se.iths.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ElementNotFoundException extends WebApplicationException {

    public ElementNotFoundException(String message) {
        super(Response.status(Response.Status.NOT_FOUND)
                .entity("There is no result with : ["+message+"]!")
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build());
    }
}
