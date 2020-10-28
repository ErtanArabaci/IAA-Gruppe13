package de.nordakademie.iaa.roommgmt.dao;


import de.nordakademie.iaa.roommgmt.model.ClubMember;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * The clubMember DAO that manages all persistence functionality.
 *
 * @author Kim Bartikowski, Ertan Arabaci
 */

public class ClubMemberDAO {

    private EntityManager entityManager;

    public void persistClubMember(ClubMember clubMember) throws ConstraintViolationException {
        entityManager.persist(clubMember);
    }

    public List<ClubMember> listClubMembers() { return entityManager.createQuery( "select clubMember from ClubMember clubMember").getResultList();}

    public ClubMember loadClubMember(Long id) { return entityManager.find(ClubMember.class, id);}

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) { this.entityManager = entityManager;}

}
