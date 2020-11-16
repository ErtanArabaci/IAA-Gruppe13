package de.nordakademie.iaa.clubmembermgt.controller;

import de.nordakademie.iaa.clubmembermgt.model.ClubMember;
import de.nordakademie.iaa.clubmembermgt.service.ClubMemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * implementation of a controller for the club member accounting logic
 *
 * @author Kim Bartikowski, Ertan Arabaci, Torben Labs
 */
@RestController
public class ClubMemberAccountingController {

    private ClubMemberService clubMemberService;

    /**
     * loads a club member
     *
     * @param id id for the club member that is to be loaded
     * @return returns the club member with the given id
     */
    @GetMapping("/club-member-accounting/{id}")
    ClubMember loadClubMember(@PathVariable Long id) {
        return clubMemberService.loadClubMember(id);

    }

    /**
     * get the club member
     *
     */
    @RequestMapping(path = "/club-member-accounting/{id}")
    public class ClubMemberOverviewController {
        @RequestMapping(method = GET)
        public ClubMember loadClubMember(@PathVariable Long id) {
            return clubMemberService.loadClubMember(id);
        }
    }

    /**
     * sets the club member service
     * @param clubMemberService the new club member service
     */
    @Inject
    public void setClubMemberService(ClubMemberService clubMemberService) {
        this.clubMemberService = clubMemberService;
    }

}
