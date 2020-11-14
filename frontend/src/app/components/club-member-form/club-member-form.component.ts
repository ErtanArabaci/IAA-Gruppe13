import {Component, EventEmitter, NgModule, OnInit, Output} from '@angular/core';
import {ClubMember} from "../../model/clubMember";
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {ClubMemberService} from "../../services/club-member.service";


@Component({
  selector: 'app-club-member-form',
  templateUrl: './club-member-form.component.html',
  styleUrls: ['./club-member-form.component.css']
})

export class ClubMemberFormComponent implements OnInit {
  clubMember!: ClubMember;

  @Output() cancel = new EventEmitter();
  @Output() save = new EventEmitter<ClubMember>();


  constructor(
    private route: ActivatedRoute,
    private clubMemberService: ClubMemberService,
    private location: Location
  ) {
  }

  ngOnInit(): void {
    this.getClubMember();
  }

  getClubMember(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.clubMemberService.getClubMember(id as unknown as number)
      .subscribe(clubMember => {
        console.log(clubMember)
        console.log(typeof clubMember.clubMemberBirthday)
        this.clubMember = {
          ...clubMember,
          clubMemberBirthday: new Date(clubMember.clubMemberBirthday).toLocaleDateString('en-EN')
        };

        console.log(this.clubMember.clubMemberBirthday)
      });
  }

  deleteClubMember(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.clubMemberService.deleteClubMember(id as unknown as number).subscribe();
  }

  onCancel(): void {
    this.cancel.emit();
  }

  updateClubMember(clubMember: ClubMember): void{
    this.clubMemberService.updateClubMember(clubMember);
  }

}
