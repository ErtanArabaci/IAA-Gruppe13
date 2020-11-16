package de.nordakademie.iaa.clubmembermgt.service;

import de.nordakademie.iaa.clubmembermgt.dao.ClubMemberDAO;
import de.nordakademie.iaa.clubmembermgt.model.ClubMember;
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
        clubMember.setExitDate(null);
        clubMember.setTerminationDate(null);
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
