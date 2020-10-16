package de.nordakademie.iaa.roommgmt.dao;

import de.nordakademie.iaa.roommgmt.model.Lecture;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * The lecture DAO that manages all persistence functionality.
 *
 * @author Stephan Anft
 */
public class LectureDAO {

    /**
     * The current entity manager.
     */
    private EntityManager entityManager;

    /**
     * Takes a new lecture and stores it in the database.
     *
     * @param lecture The lecture to be persisted.
     */
    public void persistLecture(Lecture lecture) {
        entityManager.persist(lecture);
    }

    /**
     * List all lectures currently stored in the database.
     *
     * @return a list of Lecture entities. If no lecture was found an empty list is
     * returned.
     */
    @SuppressWarnings("unchecked")
    public List<Lecture> listLectures() {
        return entityManager.createQuery("select lecture from Lecture lecture").getResultList();
    }

    /**
     * Returns the lecture identified by the given id.
     *
     * @param id The identifier.
     * @return the found entity or {@code null} if no entity was found with given identifier.
     */
    public Lecture loadLecture(Long id) {
        return entityManager.find(Lecture.class, id);
    }

    /**
     * Deletes the lecture.
     *
     * @param lecture The lecture.
     */
    public void deleteLecture(Lecture lecture) {
        entityManager.remove(lecture);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
