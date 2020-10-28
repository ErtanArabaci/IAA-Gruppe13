package de.nordakademie.iaa.roommgmt.controller;

import de.nordakademie.iaa.roommgmt.model.ClubMember;
import de.nordakademie.iaa.roommgmt.service.ClubMemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * REST controller for the clubMember entity.
 *
 * @author Kim Bartikowski, Ertan Arabaci
 */

@RestController
@RequestMapping(path = "/club-members")
public class ClubMemberOverviewController {

    private ClubMemberService clubMemberService;

    @RequestMapping(method = GET)
    public List<ClubMember> listClubMembers() {
        return clubMemberService.listClubMembers();
    }

    @Inject
    public void setClubMemberService(ClubMemberService clubMemberService) {
        this.clubMemberService = clubMemberService;
    }
}

