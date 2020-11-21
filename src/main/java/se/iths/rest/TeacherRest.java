package se.iths.rest;

import se.iths.annotation.CorrectNameFormat;
import se.iths.annotation.NameProcessor;
import se.iths.entity.Teacher;
import se.iths.exception.ElementNotFoundException;
import se.iths.exception.ElementSuccessfullyDeleted;
import se.iths.exception.IdNotFoundException;
import se.iths.service.TeacherService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {


    @Inject
    TeacherService teacherService;
    NameProcessor nameProcessor;

    @Inject
    public TeacherRest(@CorrectNameFormat NameProcessor nameProcessor) {
        this.nameProcessor = nameProcessor;
    }

    @Path("all")
    @GET
    public List<Teacher> getAll(){
        return teacherService.getAllTeachers();
    }

    @Path("{id}")
    @GET
    public Response getOneTeacherById(@PathParam("id") Long id){
        var teacher = teacherService.findTeacherById(id);
        return Response.ok(teacher).build();
    }

    @Path("lastname/{lastName}")
    @GET
    public Response getOneTeacherByLastName(@PathParam("lastName") String lastName){
        var teacher = teacherService.findTeacherByLastName(nameProcessor.processName(lastName));
        if (teacher == null){
            throw new ElementNotFoundException(lastName);
        }else {
            return Response.ok(teacher).build();
        }
    }

    @Path("create")
    @POST
    public Response createTeacher(Teacher teacher){
          teacherService.createTeacher(teacher);
            return Response.ok(teacher).build();
    }

    @Path("update")
    @PUT
    public Response updateTeacher(Teacher teacher){
        if (teacher.getId() != null) {
            if (teacherService.findTeacherById(teacher.getId()) != null) {
                String firstNameProcessed = nameProcessor.processName(teacher.getFirstName());
                String lastNameProcessed = nameProcessor.processName(teacher.getLastName());
                var teacherProcessed = new Teacher(firstNameProcessed, lastNameProcessed, teacher.getEmail(), teacher.getPhoneNumber());
                teacherService.updateTeacher(teacherProcessed);
                return Response.ok(teacherProcessed).build();
            }else {
                throw new IdNotFoundException( "There is no student with this ID :"+teacher.getId());
            }
        }
        else {
            throw new IdNotFoundException( "The Id is required to make update");
        }
    }

    @Path("{id}")
    @DELETE
    public Response deleteTeacher(@PathParam("id") Long id){
        var student = teacherService.findTeacherById(id);
        if (student == null){
            throw new ElementNotFoundException(""+id);
        }else {
            teacherService.deleteTeacher(id);
            throw new ElementSuccessfullyDeleted(""+id);
        }
    }
}
