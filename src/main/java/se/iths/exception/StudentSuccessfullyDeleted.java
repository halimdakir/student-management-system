package se.iths.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class StudentSuccessfullyDeleted extends WebApplicationException {
    public StudentSuccessfullyDeleted(String lastName) {
        super(Response.ok().entity("The student with name ["+lastName+"] is successfully deleted!").type(MediaType.TEXT_PLAIN_TYPE).build());
    }
}
