package se.iths.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class StudentNotFound extends WebApplicationException {

    public StudentNotFound(String lastName) {
        super(Response.status(Response.Status.NOT_FOUND).entity("This name ["+lastName+"] does not exist!").type(MediaType.TEXT_PLAIN_TYPE).build());
    }
}
