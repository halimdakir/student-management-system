package se.iths.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RequiredFieldsException extends WebApplicationException {
    public RequiredFieldsException() {
        super(Response.status(Response.Status.BAD_REQUEST)
                .entity("First name, Last name, and Email are required!")
                .type(MediaType.TEXT_PLAIN_TYPE).build());
    }
}
