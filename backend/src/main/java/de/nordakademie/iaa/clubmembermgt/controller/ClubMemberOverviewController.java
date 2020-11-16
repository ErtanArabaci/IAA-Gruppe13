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
 * @author Kim Bartikowski, Ertan Arabaci, Torben Labs
 */

@RestController
public class ClubMemberOverviewController {

    private ClubMemberService clubMemberService;

    /**
     * Gives a list from all club members back
     *
     * @return a list of club members
     */
    @GetMapping("/club-members")
    public List<ClubMember> listClubMembers() {
        return clubMemberService.listClubMembers();
    }

    /**
     * Delete a club member
     *
     * @param id the id of the club member to be deleted
     * @return a http statement
     */
    @DeleteMapping(path = "/club-members/{id}")
    public ResponseEntity<?> deleteClubMember(@PathVariable Long id) {
        this.clubMemberService.deleteClubMember(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Updates a club member
     *
     * @param clubMember
     * @return an updated club member
     */
    @PutMapping(path = "/club-members")
    public void updateClubMember(@RequestBody ClubMember clubMember) {
        this.clubMemberService.updateClubMember(clubMember);
    }

    /**
     * Creates a club member
     *
     * @param clubMember
     * @return return club members
     */
    @PostMapping(path = "/club-members")
    public void createClubMember(@RequestBody ClubMember clubMember) {
        this.clubMemberService.createClubMember(clubMember);
    }

    /**
     * Gives an empty club member back
     *
     * @return an empty club member
     */
    @GetMapping(path = "/empty-club-member")
    public ClubMember loadEmptyClubMember() {
        return clubMemberService.loadEmptyClubMember();
    }

    @Inject
    public void setClubMemberService(ClubMemberService clubMemberService) {
        this.clubMemberService = clubMemberService;
    }
}

