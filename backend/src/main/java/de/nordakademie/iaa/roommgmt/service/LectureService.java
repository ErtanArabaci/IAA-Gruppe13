package de.nordakademie.iaa.roommgmt.service;

import de.nordakademie.iaa.roommgmt.dao.LectureDAO;
import de.nordakademie.iaa.roommgmt.model.Lecture;

import javax.inject.Inject;
import java.util.List;

public class LectureService {

    private LectureDAO lectureDAO;

    /**
     * Takes a new lecture and stores it in the database.
     *
     * @param lecture The lecture to be persisted.
     */
    public void createLecture(Lecture lecture) {
        lectureDAO.persistLecture(lecture);
    }

    /**
     * List all lectures currently stored in the database.
     *
     * @return a list of Lecture entities. If no lecture was found an empty list is
     * returned.
     */
    @SuppressWarnings("unchecked")
    public List<Lecture> listLectures() {
        return lectureDAO.listLectures();
    }

    /**
     * Deletes the lecture with the given id.
     *
     * @param id The identifier.
     * @throws EntityNotFoundException if no lecture could be found for the given id.
     */
    public void deleteLecture(Long id) throws EntityNotFoundException {
        Lecture lecture = lectureDAO.loadLecture(id);
        if (lecture == null) {
            throw new EntityNotFoundException();
        }
        lectureDAO.deleteLecture(lecture);
    }

    @Inject
    public void setLectureDAO(LectureDAO lectureDAO) {
        this.lectureDAO = lectureDAO;
    }
}
