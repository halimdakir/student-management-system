package se.iths.rest;


import se.iths.entity.Student;
import se.iths.exception.StudentNotFound;
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


    @Path("all")
    @GET
    public List<Student> getAll(){
        return studentService.getAllStudents();
    }

    @Path("{lastName}")
    @GET
    public Response getOneStudent(@PathParam("lastName") String lastName){
        var student = studentService.findStudentByLastName(lastName);
        if (student==null){
            throw new StudentNotFound("This name ["+lastName+"] does not exist!");
        }else {
            return Response.ok(student).build();
        }
    }

    @Path("create")
    @POST
    public Response createStudent(Student student){
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("update")
    @PUT
    public Response updateStudent(Student student){
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }

    @Path("{lastName}")
    @DELETE
    public Response deleteStudent(@PathParam("lastName") String lastName){
        var student = studentService.findStudentByLastName(lastName);
        if (student != null){
            studentService.deleteStudent(lastName);
            return Response.ok(student).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
