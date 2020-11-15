import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ClubMember} from "../../model/clubMember";
import {ClubMemberService} from "../../services/club-member.service";
import {Observable} from "rxjs";


@Component({
  selector: 'app-club-member-list',
  templateUrl: './club-member-list.component.html',
  styleUrls: ['./club-member-list.component.css']
})
export class ClubMemberListComponent implements OnInit {
  clubMembers: ClubMember[] = [];
  @Output() selectClubMember = new EventEmitter<ClubMember>();
  term: any;

  constructor(    private clubMemberService: ClubMemberService,
  ) { }

  ngOnInit(): void {
    this.getClubMembers();
  }

  getClubMembers(){
    this.clubMemberService.loadClubMembers().subscribe((clubMembers: ClubMember[]) => {
      this.clubMembers = clubMembers;
    });
  }

  onSelect(clubMember: ClubMember): void {
    this.selectClubMember.emit(clubMember);
  }

}
