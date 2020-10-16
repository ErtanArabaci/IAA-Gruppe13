package de.nordakademie.iaa.roommgmt.service;

import de.nordakademie.iaa.roommgmt.dao.RoomDAO;
import de.nordakademie.iaa.roommgmt.model.Room;
import org.hibernate.exception.ConstraintViolationException;

import javax.inject.Inject;
import java.util.List;

public class RoomService {

    private RoomDAO roomDAO;

    /**
     * Takes the new room and stores it in the database.
     *
     * @param room The room to be persisted.
     * @throws EntityAlreadyPresentException if a room with the same building/room number
     *                                       combination is already present in the database.
     */
    public void createRoom(Room room) throws EntityAlreadyPresentException {
        try {
            roomDAO.persistRoom(room);
        }
        catch (ConstraintViolationException e) {
            throw new EntityAlreadyPresentException();
        }
    }

    /**
     * List all rooms currently stored in the database.
     *
     * @return a list of Room entities. If no room was found an empty list is
     * returned.
     */
    @SuppressWarnings("unchecked")
    public List<Room> listRooms() {
        return roomDAO.listRooms();
    }

    /**
     * Returns the room identified by the given id.
     *
     * @param id The identifier.
     * @return the found entity or {@code null} if no entity was found with given identifier.
     */
    public Room loadRoom(Long id) {
        return roomDAO.loadRoom(id);
    }

    /**
     * Updates a room entity and stores the changes into the database.
     *
     * @param id        The identifier.
     * @param seats     The number of seats.
     * @param projector The projector flag.
     * @throws EntityNotFoundException if no room could be found for the given id.
     */
    public void updateRoom(Long id, int seats, boolean projector) throws EntityNotFoundException {
        Room room = loadRoom(id);
        if (room == null) {
            throw new EntityNotFoundException();
        }
        room.setSeats(seats);
        room.setProjectorPresent(projector);
    }

    /**
     * Deletes the room with the given id.
     *
     * @param id The identifier.
     * @throws EntityNotFoundException if no room could be fount for the given id.
     */
    public void deleteRoom(Long id) throws EntityNotFoundException {
        Room room = loadRoom(id);
        if (room == null) {
            throw new EntityNotFoundException();
        }
        roomDAO.deleteRoom(room);
    }

    @Inject
    public void setRoomDAO(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }
}
