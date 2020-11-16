package de.nordakademie.iaa.clubmembermgt.service;

import de.nordakademie.iaa.clubmembermgt.dao.ClubMemberDAO;
import de.nordakademie.iaa.clubmembermgt.model.ClubMember;
import org.hibernate.exception.ConstraintViolationException;

import javax.inject.Inject;
import java.util.List;

/**
 * The implementation of a service for ClubMember
 *
 * @author Kim Bartikowski, Torben Labs, Ertan Arabaci
 */
public class ClubMemberService {

    private ClubMemberDAO clubMemberDAO;

    /**
     * Calls dao to create a club member
     *
     * @param clubMember to create
     */
    public void createClubMember(ClubMember clubMember) {
        clubMember.setExitDate(null);
        clubMember.setTerminationDate(null);
        clubMemberDAO.createClubMember(clubMember);
    }

    /**
     * Calls dao to update a club member
     *
     * @param clubMember to be updated
     */
    public void updateClubMember(ClubMember clubMember) {
        clubMemberDAO.updateClubMember(clubMember);
    }

    /**
     * Calls dao to delete a club member
     *
     * @param id id of the club member that is to be deleted
     */
    public void deleteClubMember(Long id) {
        clubMemberDAO.deleteClubMember(id);
    }

    /**
     * Calls dao to load an empty club member
     *
     * @return an empty club member
     */
    public ClubMember loadEmptyClubMember() {
        return clubMemberDAO.loadEmptyClubMember();
    }

    /**
     * Calls dao to get a list of club members
     *
     * @return a list of club members
     */
    @SuppressWarnings("unchecked")
    public List<ClubMember> listClubMembers() {
        return clubMemberDAO.listClubMembers();
    }

    /**
     * Calls dao to get a club members
     *
     * @return a club members
     */
    public ClubMember loadClubMember(Long clubMemberId) {
        return clubMemberDAO.loadClubMember(clubMemberId);
    }

    @Inject
    public void setClubMemberDAO(ClubMemberDAO clubMemberDAO) {
        this.clubMemberDAO = clubMemberDAO;
    }
}

