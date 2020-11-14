import {Component, EventEmitter, NgModule, OnInit, Output} from '@angular/core';
import {ClubMember} from "../../model/clubMember";
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {ClubMemberService} from "../../services/club-member.service";
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';

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
        this.clubMember = clubMember;
      });
  }

  deleteClubMember(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.clubMemberService.deleteClubMember(id as unknown as number);
  }

  onCancel(): void {
    this.cancel.emit();
  }

  updateClubMember(clubMember: ClubMember): void{
    this.clubMemberService.updateClubMember(clubMember);
  }

}
