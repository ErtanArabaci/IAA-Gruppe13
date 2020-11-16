package de.nordakademie.iaa.clubmembermgt.controller;

import de.nordakademie.iaa.clubmembermgt.model.ClubMember;
import de.nordakademie.iaa.clubmembermgt.service.ClubMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * REST controller for the clubMember entity.
 *
 * @author Kim Bartikowski, Ertan Arabaci
 */

@RestController
public class ClubMemberOverviewController {

    private ClubMemberService clubMemberService;

    @GetMapping("/club-members")
    public List<ClubMember> listClubMembers() {
        return clubMemberService.listClubMembers();
    }

    @DeleteMapping(path = "/club-members/{id}")
    public ResponseEntity<?> deleteClubMember(@PathVariable Long id) {
        System.out.println("Delete clubMember " + id);
        this.clubMemberService.deleteClubMember(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(path = "/club-members")
    public void updateClubMember(@RequestBody ClubMember clubMember){
        System.out.println("Update clubMember " + clubMember.getClubMemberId());
        this.clubMemberService.updateClubMember(clubMember);
    }

    @PostMapping(path = "/club-members")
    public void createClubMember(@RequestBody ClubMember clubMember){
        this.clubMemberService.createClubMember(clubMember);
    }

    @GetMapping(path = "/empty-club-member")
    public ClubMember loadEmptyClubMember(){
        return clubMemberService.loadEmptyClubMember();
    }

    @Inject
    public void setClubMemberService(ClubMemberService clubMemberService) {
        this.clubMemberService = clubMemberService;
    }
}

