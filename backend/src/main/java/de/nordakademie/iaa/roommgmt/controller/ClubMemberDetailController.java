package de.nordakademie.iaa.roommgmt.controller;

import de.nordakademie.iaa.roommgmt.model.ClubMember;
import de.nordakademie.iaa.roommgmt.service.ClubMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class ClubMemberDetailController {

    private ClubMemberService clubMemberService;

    @GetMapping("/club-member-form/{id}")
    ClubMember one(@PathVariable Long id){
        System.out.println(id);
        return clubMemberService.loadClubMember(id);

    }

    @Inject
    public void setClubMemberService(ClubMemberService clubMemberService) {
        this.clubMemberService = clubMemberService;
    }

}
