package se.iths.rest;


import se.iths.annotation.CorrectNameFormat;
import se.iths.annotation.NameProcessor;
import se.iths.entity.Student;
import se.iths.exception.StudentNotFound;
import se.iths.exception.StudentSuccessfullyDeleted;
import se.iths.service.StudentService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;
    NameProcessor nameProcessor;

    @Inject
    public StudentRest(@CorrectNameFormat NameProcessor nameProcessor) {
        this.nameProcessor = nameProcessor;
    }

    @Path("all")
    @GET
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @Path("{lastName}")
    @GET
    public Response getOneStudent(@PathParam("lastName") String lastName){
        String lastNameProcessed = nameProcessor.processName(lastName);
        var student = studentService.findStudentByLastName(lastNameProcessed);
        if (student==null){
            throw new StudentNotFound(lastNameProcessed);
        }else {
            return Response.ok(student).build();
        }
    }

    @Path("create")
    @POST
    public Response createStudent(Student student){
        String firstNameProcessed = nameProcessor.processName(student.getFirstName());
        String lastNameProcessed = nameProcessor.processName(student.getLastName());
        var studentProcessed = new Student(firstNameProcessed, lastNameProcessed, student.getEmail(), student.getPhoneNumber());
        studentService.createStudent(studentProcessed);
        return Response.ok(studentProcessed).build();
    }

    @Path("update")
    @PUT
    public Response updateStudent(Student student){
        String firstNameProcessed = nameProcessor.processName(student.getFirstName());
        String lastNameProcessed = nameProcessor.processName(student.getLastName());
        var studentProcessed = new Student(firstNameProcessed, lastNameProcessed, student.getEmail(), student.getPhoneNumber());
        studentService.updateStudent(studentProcessed);
        return Response.ok(studentProcessed).build();
    }

    @Path("{lastName}")
    @DELETE
    public Response deleteStudent(@PathParam("lastName") String lastName){
        String lastNameProcessed = nameProcessor.processName(lastName);
        var student = studentService.findStudentByLastName(lastNameProcessed);
        if (student == null){
            throw new StudentNotFound(lastNameProcessed);
        }else {
            studentService.deleteStudent(lastNameProcessed);
            throw new StudentSuccessfullyDeleted(lastNameProcessed);
        }
    }


}
