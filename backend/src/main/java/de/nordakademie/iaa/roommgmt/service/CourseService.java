package de.nordakademie.iaa.roommgmt.service;

import de.nordakademie.iaa.roommgmt.dao.CourseDAO;
import de.nordakademie.iaa.roommgmt.model.Course;
import org.hibernate.exception.ConstraintViolationException;

import javax.inject.Inject;
import java.util.List;

public class CourseService {

    private CourseDAO courseDAO;

    /**
     * Takes the new course and stores it in the database.
     *
     * @param course The course to be persisted.
     * @throws EntityAlreadyPresentException if a course with the same field of study/number
     *                                       combination is already present in the database.
     */
    public void createCourse(Course course) throws EntityAlreadyPresentException {
        try {
            courseDAO.persistCourse(course);
        }
        catch (ConstraintViolationException e) {
            throw new EntityAlreadyPresentException();
        }
    }

    /**
     * List all courses currently stored in the database.
     *
     * @return a list of Course entities. If no course was found an empty list is
     * returned.
     */
    @SuppressWarnings("unchecked")
    public List<Course> listCourses() {
        return courseDAO.listCourses();
    }

    /**
     * Returns the course identified by the given id.
     *
     * @param id The identifier.
     * @return the found entity or {@code null} if no entity was found with given identifier.
     */
    public Course loadCourse(Long id) {
        return courseDAO.loadCourse(id);
    }

    /**
     * Updates a course entity and stores the changes into the database.
     *
     * @param id       The identifier.
     * @param title    The course's title.
     * @param lecturer The lecturer's name.
     * @throws EntityNotFoundException if no course could be found for the given id.
     */
    public void updateCourse(Long id, String title, String lecturer) throws EntityNotFoundException {
        Course course = loadCourse(id);
        if (course == null) {
            throw new EntityNotFoundException();
        }
        course.setTitle(title);
        course.setLecturer(lecturer);
    }

    /**
     * Deletes the course with the given id.
     *
     * @param id The identifier.
     * @throws EntityNotFoundException if no course could be fount for the given id.
     */
    public void deleteCourse(Long id) throws EntityNotFoundException {
        Course course = loadCourse(id);
        if (course == null) {
            throw new EntityNotFoundException();
        }
        courseDAO.deleteCourse(course);
    }

    @Inject
    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }
}
