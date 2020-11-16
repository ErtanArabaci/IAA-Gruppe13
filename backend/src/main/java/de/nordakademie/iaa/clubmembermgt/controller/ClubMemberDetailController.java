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
 * REST controller for the clubMember entity.
 *
 * @author Kim Bartikowski, Ertan Arabaci, Torben Labs
 */
@RestController
public class ClubMemberDetailController {

    private ClubMemberService clubMemberService;

    /**
     * Gives a club members by id back
     *
     * @param id
     * @return a specific club member by id
     */
    @GetMapping("/club-member-form/{id}")
    public ClubMember loadClubMemberById(@PathVariable Long id) {
        return clubMemberService.loadClubMember(id);

    }

    /**
     * Loads a club member
     *
     * @return a specific club member by id
     */
    @RequestMapping(path = "/club-member-form/{id}")
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
