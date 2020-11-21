package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.exception.ElementNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;


    public Set<Student> getStudentBySubject(String subjectName) {
        try{
            var subject = (Subject) entityManager
                    .createQuery("SELECT DISTINCT sb FROM Subject sb INNER JOIN FETCH sb.students s WHERE sb.subjectName = :subjectName")
                    .setParameter("subjectName", subjectName)
                    .getSingleResult();
            return subject.getStudents();
        } catch(NoResultException e) {
            throw new ElementNotFoundException(subjectName);
        }
    }

    public Set<Student> getStudentByTeacherAndSubject(String teacherName, String subjectName) {
        try{
            var subject = (Subject) entityManager
                    .createQuery("SELECT DISTINCT b FROM Subject b INNER JOIN FETCH b.teacher t INNER JOIN FETCH b.students s WHERE t.firstName = :teacherName AND b.subjectName = :subjectName")
                    .setParameter("teacherName", teacherName)
                    .setParameter("subjectName", subjectName)
                    .getSingleResult();
            return subject.getStudents();
        } catch(NoResultException e) {
            throw new ElementNotFoundException(teacherName+" & "+subjectName);
        }
    }

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

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
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
