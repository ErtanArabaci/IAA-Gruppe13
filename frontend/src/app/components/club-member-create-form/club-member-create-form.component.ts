import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ClubMemberService} from "../../services/club-member.service";
import {Location} from "@angular/common";
import {ClubMember} from "../../model/clubMember";

@Component({
  selector: 'app-club-member-create-form',
  templateUrl: './club-member-create-form.component.html',
  styleUrls: ['./club-member-create-form.component.css']
})
export class ClubMemberCreateFormComponent implements OnInit {
  clubMember!: ClubMember;

  @Output() cancel = new EventEmitter();


  constructor(  private clubMemberService: ClubMemberService,
  ) {
  }

  ngOnInit(): void {
    this.getEmptyClubMember()
  }

  getEmptyClubMember(){
    this.clubMemberService.getEmptyClubMember().subscribe();
  }

  updateClubMember(clubMember: ClubMember): void{
    this.clubMemberService.updateClubMember(clubMember).subscribe();
  }

  onCancel(): void {
    this.cancel.emit();
  }

}
