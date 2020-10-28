import {Component, OnInit} from '@angular/core';
import {ClubMember} from "../../model/clubMember";
import {ClubMemberService} from "../../services/club-member.service";

@Component({
  selector: 'app-club-members',
  templateUrl: './club-members.component.html',
  styleUrls: ['./club-members.component.css']
})
export class ClubMembersComponent implements OnInit {
  clubMembers: ClubMember[] = [];
  selectedClubMember?: ClubMember;

  constructor(private clubMemberService: ClubMemberService) {
  }

  ngOnInit(): void {
    this.reloadClubMemberList();
  }

  private reloadClubMemberList() {
    this.clubMemberService.loadClubMembers().subscribe((clubMembers: ClubMember[]) => {
      this.clubMembers = clubMembers;
    });
  }

  onSelectClubMember(clubMember: ClubMember): void{
    this.selectedClubMember = {...clubMember};
  }

  onCancelEdit() {
    this.selectedClubMember = undefined;
  }

  onSave(clubMember: ClubMember) {
    this.clubMemberService.updateClubMembers(clubMember).subscribe( () => {
      this.selectedClubMember = undefined;
      this.reloadClubMemberList();
    } )
  }


}
