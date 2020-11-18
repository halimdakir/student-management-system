package se.iths.rest;

import se.iths.annotation.CorrectNameFormat;
import se.iths.annotation.NameProcessor;
import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.service.SubjectService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("subject")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {


    @Inject
    SubjectService subjectService;
    NameProcessor nameProcessor;

    @Inject
    public SubjectRest(@CorrectNameFormat NameProcessor nameProcessor) {
        this.nameProcessor = nameProcessor;
    }

    @Path("all")
    @GET
    public List<Subject> getAll(){
        return subjectService.getAllSubjects();
    }

}
