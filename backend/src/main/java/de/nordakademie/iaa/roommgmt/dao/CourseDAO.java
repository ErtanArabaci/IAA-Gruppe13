package de.nordakademie.iaa.roommgmt.dao;

import de.nordakademie.iaa.roommgmt.model.Course;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * The course DAO that manages all persistence functionality.
 *
 * @author Stephan Anft
 */
public class CourseDAO {

    /**
     * The current entity manager.
     */
    private EntityManager entityManager;

    /**
     * Takes the course and stores it in the database.
     *
     * @param course The course to be persisted.
     * @throws ConstraintViolationException if a course with the same field of study/number
     *                                      combination is already present in the database.
     */
    public void persistCourse(Course course) throws ConstraintViolationException {
        entityManager.persist(course);
    }

    /**
     * List all courses currently stored in the database.
     *
     * @return a list of Course entities. If no course was found an empty list is
     * returned.
     */
    @SuppressWarnings("unchecked")
    public List<Course> listCourses() {
        return entityManager.createQuery("select course from Course course").getResultList();
    }

    /**
     * Returns the course identified by the given id.
     *
     * @param id The identifier.
     * @return the found entity or {@code null} if no entity was found with given identifier.
     */
    public Course loadCourse(Long id) {
        return entityManager.find(Course.class, id);
    }

    /**
     * Deletes the course.
     *
     * @param course The course.
     */
    public void deleteCourse(Course course) {
        entityManager.remove(course);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
