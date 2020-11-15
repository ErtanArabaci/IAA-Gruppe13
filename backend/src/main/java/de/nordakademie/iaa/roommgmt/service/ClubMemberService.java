package de.nordakademie.iaa.roommgmt.service;

import de.nordakademie.iaa.roommgmt.dao.ClubMemberDAO;
import de.nordakademie.iaa.roommgmt.model.ClubMember;
import org.hibernate.exception.ConstraintViolationException;

import javax.inject.Inject;
import java.util.List;

public class ClubMemberService {

    private ClubMemberDAO clubMemberDAO;

    public void createRoom(ClubMember clubMember) throws EntityAlreadyPresentException {
        try {
            clubMemberDAO.persistClubMember(clubMember);
        } catch (
                ConstraintViolationException e) {
            throw new EntityAlreadyPresentException();
        }
    }

    public void createClubMember(ClubMember clubMember){
        clubMemberDAO.createClubMember(clubMember);
    }

    public void updateClubMember(ClubMember clubMember){
        clubMemberDAO.updateClubMember(clubMember);
    }

    public void deleteClubMember(Long id){
        clubMemberDAO.deleteClubMember(id);
    }

    public ClubMember loadEmptyClubMember(){return clubMemberDAO.loadEmptyClubMember();}


    @SuppressWarnings("unchecked")
    public List<ClubMember> listClubMembers() {
        return clubMemberDAO.listClubMembers();
    }

    public ClubMember loadClubMember(Long clubMemberId) {
        return clubMemberDAO.loadClubMember(clubMemberId);
    }

    @Inject
    public void setClubMemberDAO(ClubMemberDAO clubMemberDAO) {
        this.clubMemberDAO = clubMemberDAO;
    }
}

