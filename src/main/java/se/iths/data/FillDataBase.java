package se.iths.data;

import se.iths.entity.Student;

import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FillDataBase {
    List<Student> studentList = new ArrayList<>();

    @Produces
    List<Student> getStudentList(){
        studentList = students();
        return studentList;
    }

    private List<Student> students(){
        var student1 = new Student("Halim", "Dakir", "halim.dakir@iths.se", "0700-234 675");
        var student2 = new Student("Elena", "Elena", "elena.elena@iths.se", "0711 222 333");
        List<Student> list = Collections.synchronizedList(new ArrayList<>());
        list.add(student1);
        list.add(student2);
        return list;
    }
}
