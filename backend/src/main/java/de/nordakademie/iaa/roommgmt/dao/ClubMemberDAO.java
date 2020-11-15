package de.nordakademie.iaa.roommgmt.dao;


import de.nordakademie.iaa.roommgmt.model.ClubMember;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Iterator;
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

    public List<ClubMember> listClubMembers() {
        return entityManager.createQuery("select clubMember from ClubMember clubMember").getResultList();
    }

    public ClubMember loadClubMember(Long id) {
        return entityManager.find(ClubMember.class , id);
    }

    public void createClubMember(ClubMember clubMember){
        entityManager.getTransaction().begin();
        entityManager.persist(clubMember);
        entityManager.getTransaction().commit();
    }

    public void updateClubMember(ClubMember clubMember){


        System.out.println("Neuer Name: " + clubMember.getClubMemberName());

        ClubMember attachedClubMember = entityManager.merge(clubMember);

    }

    public void deleteClubMember(Long id){
        entityManager.remove(entityManager.find(ClubMember.class, id));
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ClubMember loadEmptyClubMember(){
        ClubMember clubMember = new ClubMember();

        return clubMember;
    }

}
