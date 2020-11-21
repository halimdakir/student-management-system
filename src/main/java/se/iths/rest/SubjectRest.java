package se.iths.rest;

import se.iths.annotation.CorrectNameFormat;
import se.iths.annotation.NameProcessor;
import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.exception.ElementNotFoundException;
import se.iths.exception.ElementSuccessfullyDeleted;
import se.iths.exception.IdNotFoundException;
import se.iths.service.SubjectService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    @Path("{id}")
    @GET
    public Response getOneSubjectById(@PathParam("id") Long id){
        var subject = subjectService.findSubjectById(id);
        return Response.ok(subject).build();
    }

    @Path("name/{name}")
    @GET
    public Response getOneSubjectByName(@PathParam("name") String name){
        var subject = subjectService.findSubjectByName(nameProcessor.processName(name));
        if (subject == null){
            throw new ElementNotFoundException(name);
        }else {
            return Response.ok(subject).build();
        }
    }

    @Path("create")
    @POST
    public Response createSubject(Subject subject){
        subjectService.createSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("update")
    @PUT
    public Response updateSubject(Subject subject){
        if (subject.getId() != null) {
            if (subjectService.findSubjectById(subject.getId()) != null) {
                var subjectProcessed = new Subject(nameProcessor.processName(subject.getSubjectName()));
                subjectService.updateSubject(subjectProcessed);
                return Response.ok(subjectProcessed).build();
            }else {
                throw new IdNotFoundException( "There is no student with this ID :"+subject.getId());
            }
        }
        else {
            throw new IdNotFoundException( "The Id is required to make update");
        }
    }

    @Path("{id}")
    @DELETE
    public Response deleteSubject(@PathParam("id") Long id){
        var subject = subjectService.findSubjectById(id);
        if (subject == null){
            throw new ElementNotFoundException(""+id);
        }else {
            subjectService.deleteSubject(id);
            throw new ElementSuccessfullyDeleted(""+id);
        }
    }

}
