import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ClubMember} from "../../model/clubMember";

@Component({
  selector: 'app-club-member-form',
  templateUrl: './club-member-form.component.html',
  styleUrls: ['./club-member-form.component.css']
})
export class ClubMemberFormComponent implements OnInit {
  @Input() clubMember!: ClubMember;

  @Output() cancel = new EventEmitter();
  @Output() save = new EventEmitter<ClubMember>();

  constructor() { }

  ngOnInit(): void {
  }

  onCancel(): void {
    this.cancel.emit();
  }

  onSave(): void {
    this.save.emit(this.clubMember);
  }

}
