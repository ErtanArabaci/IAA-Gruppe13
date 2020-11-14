import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ClubMember} from "../../model/clubMember";

@Component({
  selector: 'app-club-member-accounting',
  templateUrl: './club-member-accounting.component.html',
  styleUrls: ['./club-member-accounting.component.css']
})
export class ClubMemberAccountingComponent implements OnInit {
  @Input() clubMembers: ClubMember[] = [];
  @Output() selectClubMember = new EventEmitter<ClubMember>();
  term: any;

  constructor() { }

  ngOnInit(): void {
  }

}
