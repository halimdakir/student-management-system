package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class FillDataBase {

    @PersistenceContext
    EntityManager entityManager;

    //List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void fillDataBase(){
        var teacher1 = new Teacher("Pontus", "Salvador", "pontus.salvador@gmail.fr", "0700-234 675");
        var teacher2 = new Teacher("Natcha", "Tchika", "natcha.tchika@gmail.fr", "0700-234 675");

        var student1 = new Student("Halim", "Dakir", "halim.dakir@iths.se", "0700-234 675");
        var student2 = new Student("Norah", "Andersson", "norah.andersson@iths.se", "0711 222 333");
        var student3 = new Student("Lara", "Saddik", "lara@email.com", "0777 222 777");
        var student4 = new Student("Sarah", "Dakir", "saraha.dakir@email.com","0733 111 000");

        var subject1 = new Subject("Math");
        var subject2 = new Subject("Java");
        var subject3 = new Subject("Sql");

        student1.addSubject(subject1);
        student1.addSubject(subject2);
        student2.addSubject(subject1);
        student2.addSubject(subject3);
        student3.addSubject(subject1);
        student3.addSubject(subject2);
        student3.addSubject(subject3);
        student4.addSubject(subject2);
        student4.addSubject(subject3);

        teacher1.addSubject(subject1);
        teacher2.addSubject(subject2);
        teacher2.addSubject(subject3);

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);

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