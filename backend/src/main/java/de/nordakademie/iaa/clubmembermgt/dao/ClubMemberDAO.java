package de.nordakademie.iaa.clubmembermgt.dao;


import de.nordakademie.iaa.clubmembermgt.model.ClubMember;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * The clubMember DAO that manages all persistence functionality.
 *
 * @author Kim Bartikowski, Ertan Arabaci, Torben Labs
 */
@Transactional
public class ClubMemberDAO {

    private EntityManager entityManager;

    /**
     * Saves entity in the data base
     *
     * @param clubMember the club member to be saved
     */
    public void persistClubMember(ClubMember clubMember) throws ConstraintViolationException {
        entityManager.persist(clubMember);
    }

    /**
     * Gives a list of clubmembers from the database
     *
     * @return a list of clubmembers
     */
    public List<ClubMember> listClubMembers() {
        return entityManager.createQuery("select clubMember from ClubMember clubMember").getResultList();
    }

    /**
     * Loads a single club member from the database
     *
     * @param id of the club member
     * @return one club member
     */
    public ClubMember loadClubMember(Long id) {
        return entityManager.find(ClubMember.class, id);
    }

    /**
     * Creates one club member
     *
     * @param clubMember
     */
    public void createClubMember(ClubMember clubMember) {
        persistClubMember(clubMember);
    }

    /**
     * Updates the club member on the database
     *
     * @param clubMember
     */
    public void updateClubMember(ClubMember clubMember) {
        entityManager.merge(clubMember);
    }

    /**
     * Deletes the club member from the database
     *
     * @param id of the club member to be deleted
     */
    public void deleteClubMember(Long id) {
        entityManager.remove(entityManager.find(ClubMember.class, id));
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Loads an empty club member
     *
     * @return clubMember
     */
    public ClubMember loadEmptyClubMember() {
        ClubMember clubMember = new ClubMember();

        return clubMember;
    }

}
