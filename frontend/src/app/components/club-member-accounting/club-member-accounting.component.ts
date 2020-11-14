import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ClubMember} from "../../model/clubMember";
import {ActivatedRoute} from "@angular/router";
import {ClubMemberService} from "../../services/club-member.service";

@Component({
  selector: 'app-club-member-accounting',
  templateUrl: './club-member-accounting.component.html',
  styleUrls: ['./club-member-accounting.component.css']
})
export class ClubMemberAccountingComponent implements OnInit {
  clubMember!: ClubMember;
  @Input() clubMembers: ClubMember[] = [];

  @Output() selectClubMember = new EventEmitter<ClubMember>();
  term: any;

  constructor(
    private route: ActivatedRoute,
    private clubMemberService: ClubMemberService
  ) { }

  ngOnInit(): void {
  this.getClubMemberAccounting();
  }

  getClubMemberAccounting(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.clubMemberService.getClubMemberAccounting(id as unknown as number)
      .subscribe(clubMember => {
        this.clubMember = clubMember;
      });
  }

}
