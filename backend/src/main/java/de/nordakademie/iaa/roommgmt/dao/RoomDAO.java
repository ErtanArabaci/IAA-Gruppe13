package de.nordakademie.iaa.roommgmt.dao;

import de.nordakademie.iaa.roommgmt.model.Room;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

/**
 * The room DAO that manages all persistence functionality.
 *
 * @author Stephan Anft
 */
public class RoomDAO {

    /**
     * The current entity manager.
     */
    private EntityManager entityManager;

    /**
     * Takes the room and stores it in the database.
     *
     * @param room The room to be persisted.
     * @throws ConstraintViolationException if a room with the same building/room number
     *                                      combination is already present in the database.
     */
    public void persistRoom(Room room) throws ConstraintViolationException {
        entityManager.persist(room);
    }

    /**
     * List all rooms currently stored in the database.
     *
     * @return a list of Room entities. If no room was found an empty list is
     * returned.
     */
    @SuppressWarnings("unchecked")
    public List<Room> listRooms() {
        return entityManager.createQuery("select room from Room room").getResultList();
    }

    /**
     * Returns the room identified by the given id.
     *
     * @param id The identifier.
     * @return the found entity or {@code null} if no entity was found with given identifier.
     */
    public Room loadRoom(Long id) {
        return entityManager.find(Room.class, id);
    }

    /**
     * Deletes the room.
     *
     * @param room The room to be deleted.
     */
    public void deleteRoom(Room room) {
        entityManager.remove(room);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
