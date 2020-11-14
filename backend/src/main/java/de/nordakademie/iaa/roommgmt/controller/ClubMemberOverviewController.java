package de.nordakademie.iaa.roommgmt.controller;

import de.nordakademie.iaa.roommgmt.model.ClubMember;
import de.nordakademie.iaa.roommgmt.service.ClubMemberService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.sound.midi.Soundbank;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
    public void deleteClubMember(@PathVariable Long id) {
        this.clubMemberService.deleteClubMember(id);
        System.out.println("Delete clubMember " + id);
    }

    @PutMapping(path = "/club-members/{id}")
    public void updateClubMember(@PathVariable ClubMember clubMember){
        this.clubMemberService.updateClubMember(clubMember);
    }

    @PostMapping(path = "/club-members")
    public void createClubMember(ClubMember clubMember){
        this.clubMemberService.createClubMember(clubMember);
    }

    @Inject
    public void setClubMemberService(ClubMemberService clubMemberService) {
        this.clubMemberService = clubMemberService;
    }
}

