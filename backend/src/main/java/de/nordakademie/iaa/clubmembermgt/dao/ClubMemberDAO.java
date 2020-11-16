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
 * @author Kim Bartikowski, Ertan Arabaci
 */
@Transactional
public class ClubMemberDAO {

    private EntityManager entityManager;

    public void persistClubMember(ClubMember clubMember) throws ConstraintViolationException {
        entityManager.persist(clubMember);
    }

    public List<ClubMember> listClubMembers() {
        return entityManager.createQuery("select clubMember from ClubMember clubMember").getResultList();
    }

    public ClubMember loadClubMember(Long id) {
        return entityManager.find(ClubMember.class, id);
    }

    public void createClubMember(ClubMember clubMember) {
        persistClubMember(clubMember);
    }

    public void updateClubMember(ClubMember clubMember) {
        entityManager.merge(clubMember);
    }

    public void deleteClubMember(Long id) {
        entityManager.remove(entityManager.find(ClubMember.class, id));
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public ClubMember loadEmptyClubMember() {
        ClubMember clubMember = new ClubMember();

        return clubMember;
    }

}
