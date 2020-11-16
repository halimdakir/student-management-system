package se.iths.data;

import se.iths.entity.Student;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class FillDataBase {

    @PersistenceContext
    EntityManager entityManager;

    List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void fillDataBase(){
        studentList = students();
        for (Student student: studentList) {
            entityManager.persist(student);
        }
    }

    private List<Student> students(){
        var student1 = new Student("Halim", "Dakir", "halim.dakir@iths.se", "0700-234 675");
        var student2 = new Student("Norah", "Andersson", "norah.andersson@iths.se", "0711 222 333");
        List<Student> list = Collections.synchronizedList(new ArrayList<>());
        list.add(student1);
        list.add(student2);
        return list;
    }
}