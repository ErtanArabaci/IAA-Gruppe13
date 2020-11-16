package de.nordakademie.iaa.clubmembermgt.controller;

import de.nordakademie.iaa.clubmembermgt.model.ClubMember;
import de.nordakademie.iaa.clubmembermgt.service.ClubMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ClubMemberAccountingController {

    private ClubMemberService clubMemberService;

    @GetMapping("/club-member-accounting/{id}")
    ClubMember loadClubMember(@PathVariable Long id) {
        return clubMemberService.loadClubMember(id);

    }

    @RequestMapping(path = "/club-member-accounting/{id}")
    public class ClubMemberOverviewController {
        @RequestMapping(method = GET)
        public ClubMember loadClubMember(@PathVariable Long id) {
            return clubMemberService.loadClubMember(id);
        }
    }

    @Inject
    public void setClubMemberService(ClubMemberService clubMemberService) {
        this.clubMemberService = clubMemberService;
    }

}
