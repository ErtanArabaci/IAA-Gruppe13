import {Component, EventEmitter, OnInit, Output} from '@angular/core';
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
  }

  onCancel(): void {
    this.cancel.emit();
  }

  onSave(): void {
    this.save.emit(this.clubMember);
  }

}
