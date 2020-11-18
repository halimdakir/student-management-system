package se.iths.service;

import se.iths.entity.Teacher;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;


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
