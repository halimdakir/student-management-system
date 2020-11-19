package se.iths.rest;


import se.iths.annotation.CorrectNameFormat;
import se.iths.annotation.NameProcessor;
import se.iths.entity.Student;
import se.iths.exception.IdNotFoundException;
import se.iths.exception.RequiredFieldsException;
import se.iths.exception.StudentNotFoundException;
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
            throw new StudentNotFoundException(lastNameProcessed);
        }else {
            return Response.ok(student).build();
        }
    }

    /*@Path("{id}")
    @GET
    public Response getOneStudent(@PathParam("id") Long id){
        var student = studentService.findStudentById(id);
        if (student!=null){
            return Response.ok(student).build();
        }else {
            throw new StudentNotFoundException(""+id);
        }
    }*/

    @Path("create")
    @POST
    public Response createStudent(Student student){
        if (student.getFirstName() != null && student.getLastName() != null && student.getEmail() != null){
            String firstNameProcessed = nameProcessor.processName(student.getFirstName());
            String lastNameProcessed = nameProcessor.processName(student.getLastName());

            var studentProcessed = new Student(firstNameProcessed, lastNameProcessed, student.getEmail(), student.getPhoneNumber());
            studentService.createStudent(studentProcessed);
            return Response.ok(studentProcessed).build();
        }else {
            throw new RequiredFieldsException();
        }

    }

    @Path("update")
    @PUT
    public Response updateStudent(Student student){
        if (student.getId() != null) {
            if (studentService.findStudentById(student.getId()) != null) {
                String firstNameProcessed = nameProcessor.processName(student.getFirstName());
                String lastNameProcessed = nameProcessor.processName(student.getLastName());
                var studentProcessed = new Student(firstNameProcessed, lastNameProcessed, student.getEmail(), student.getPhoneNumber());
                studentService.updateStudent(studentProcessed);
                return Response.ok(studentProcessed).build();
            }else {
                throw new IdNotFoundException( "There is no student with this ID :"+student.getId());
            }
        }
        else {
            throw new IdNotFoundException( "The Id is required to make update");
        }

    }

    @Path("{lastName}")
    @DELETE
    public Response deleteStudent(@PathParam("lastName") String lastName){
        String lastNameProcessed = nameProcessor.processName(lastName);
        var student = studentService.findStudentByLastName(lastNameProcessed);
        if (student == null){
            throw new StudentNotFoundException(lastNameProcessed);
        }else {
            studentService.deleteStudent(lastNameProcessed);
            throw new StudentSuccessfullyDeleted(lastNameProcessed);
        }
    }


}
