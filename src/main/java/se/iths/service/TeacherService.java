package se.iths.service;

import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.exception.ElementNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;


    public Teacher getTeacherBySubject(String subjectName) {
        try{
            var subject = (Subject) entityManager
                    .createQuery("SELECT DISTINCT sb FROM Subject sb INNER JOIN FETCH sb.teacher t WHERE sb.subjectName = :subjectName")
                    .setParameter("subjectName", subjectName)
                    .getSingleResult();
            return subject.getTeacher();
        } catch(NoResultException e) {
            throw new ElementNotFoundException(subjectName);
        }
    }

    public Teacher createTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    public Teacher updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
        return teacher;
    }

    public Teacher findTeacherByLastName(String lastName) {
        try {
            return  entityManager.createQuery(
                    "SELECT t FROM Teacher t WHERE t.lastName LIKE :lastName", Teacher.class)
                    .setParameter("lastName", lastName)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    public Teacher findTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery(
                "SELECT t FROM Teacher t", Teacher.class)
                .getResultList();
    }

    public void deleteTeacher(Long id){
        entityManager.remove(entityManager.find(Teacher.class, id));
    }

}
