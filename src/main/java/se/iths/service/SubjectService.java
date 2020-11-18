package se.iths.service;

import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;


    public Subject createSubject(Subject subject) {
        entityManager.persist(subject);
        return subject;
    }

    public Subject updateSubject(Subject subject) {
        entityManager.merge(subject);
        return subject;
    }

    public Subject findSubjectByName(String name) {
        try {
            return  entityManager.createQuery(
                    "SELECT s FROM Subject s WHERE s.subjectName LIKE :name", Subject.class)
                    .setParameter("name", name)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
    }

    public Subject findSubjectById(Long id) {
        return entityManager.find(Subject.class, id);
    }

    public List<Subject> getAllSubjects() {
        return entityManager.createQuery(
                "SELECT s FROM Subject s", Subject.class)
                .getResultList();
    }

    public void deleteSubject(Long id){
        entityManager.remove(entityManager.find(Subject.class, id));
    }
}
