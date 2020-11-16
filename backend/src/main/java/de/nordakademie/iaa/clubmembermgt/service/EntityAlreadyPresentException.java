package de.nordakademie.iaa.clubmembermgt.service;

/**
 * Exception indicating an already present entity.
 *
 * @author Kim Bartikowski, Torben Labs, Ertan Arabaci
 */
public class EntityAlreadyPresentException extends Exception {

    /**
     * Serial version uid.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public EntityAlreadyPresentException() {
        super();
    }

    /**
     * Constructor with message.
     *
     * @param message The message.
     */
    public EntityAlreadyPresentException(String message) {
        super(message);
    }
}
