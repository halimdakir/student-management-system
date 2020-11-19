package se.iths.data;

import se.iths.entity.Student;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class FillDataBase {

    @PersistenceContext
    EntityManager entityManager;

    //List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void fillDataBase(){
        Teacher teacher1 = new Teacher("Pontus", "Salvador", "pontus.salvador@gmail.fr", "0700-234 675");
        Teacher teacher2 = new Teacher("Natcha", "Tchika", "natcha.tchika@gmail.fr", "0700-234 675");


        Student student1 = new Student("Halim", "Dakir", "halim.dakir@iths.se", "0700-234 675");
        Student student2 = new Student("Norah", "Andersson", "norah.andersson@iths.se", "0711 222 333");

        teacher1.addStudent(student1);
        teacher1.addStudent(student2);
        teacher2.addStudent(student2);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);







        //student1.getTeachers().addAll(Arrays.asList(teacher1, teacher2));
        //student2.getTeachers().addAll(Collections.singletonList(teacher2));
        //teacher2.getStudents().addAll(Arrays.asList(student1, student2));
        //teacher1.getStudents().addAll(Collections.singletonList(student1));


        //entityManager.merge(teacher2);
        //entityManager.persist(teacher1);
        //entityManager.persist(teacher2);

        /*studentList = students();

        for (Student student: studentList) {
            entityManager.persist(student);
        }*/
    }

    /*private List<Student> students() {
        var student1 = new Student("Halim", "Dakir", "halim.dakir@iths.se", "0700-234 675");
        var student2 = new Student("Norah", "Andersson", "norah.andersson@iths.se", "0711 222 333");
        List<Student> list = Collections.synchronizedList(new ArrayList<>());
        list.add(student1);
        list.add(student2);
        return list;
    }*/
}