import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ClubMember} from "../../model/clubMember";

@Component({
  selector: 'app-club-member-list',
  templateUrl: './club-member-list.component.html',
  styleUrls: ['./club-member-list.component.css']
})
export class ClubMemberListComponent implements OnInit {
  @Input() clubMembers: ClubMember[] = [];
  @Output() selectClubMember = new EventEmitter<ClubMember>();

  constructor() { }

  ngOnInit(): void {
  }

  onSelect(clubMember: ClubMember): void {
    this.selectClubMember.emit(clubMember);
  }

}
