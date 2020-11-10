package se.iths.service;

import se.iths.entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;


    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student updateStudent(Student student) {
        entityManager.merge(student);
        return student;
    }

    public Student findStudentByLastName(String lastName) {
        try {
            return  entityManager.createQuery(
                    "SELECT s FROM Student s WHERE s.lastName LIKE :lastName", Student.class)
                    .setParameter("lastName", lastName)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch(NoResultException e) {
        return null;
        }
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery(
                "SELECT s FROM Student s", Student.class)
                .getResultList();
    }

    public void deleteStudent(String lastName){
        entityManager.remove(entityManager.createQuery(
                "SELECT s FROM Student s WHERE s.lastName LIKE :lastName", Student.class)
                .setParameter("lastName", lastName)
                .getSingleResult());
    }
}
