import {Component, EventEmitter, NgModule, OnInit, Output} from '@angular/core';
import {ClubMember} from "../../model/clubMember";
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import {ClubMemberService} from "../../services/club-member.service";
import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {MembershipType} from "../../model/membership-type.enum";
import {isNumeric} from "rxjs/internal-compatibility";


@Component({
  selector: 'app-club-member-form',
  templateUrl: './club-member-form.component.html',
  styleUrls: ['./club-member-form.component.css']
})

export class ClubMemberFormComponent implements OnInit {
  keys = Object.keys;
  clubMembers: ClubMember[] = [];

  clubMember: ClubMember = {
    clubMemberId: 0,
    clubMemberName: "",
    clubMemberAdress: "",
    clubMemberBirthday: new Date,
    entranceDate: new Date,
    terminationDate: new Date,
    exitDate: new Date,
    membership_type: "",
    annualFee: 0,
    annualPaymentList: "",
    iban: ""
  };
  membershipTypeEnum = MembershipType;

  @Output() cancel = new EventEmitter();
  @Output() save = new EventEmitter<ClubMember>();
  isNew: boolean = true;

  constructor(
    private route: ActivatedRoute,
    private clubMemberService: ClubMemberService,
    private location: Location,
  ) {
  }

  ngOnInit(): void {
    this.getClubMember();
    this.getClubMembers();
  }

  getClubMembers() {
    this.clubMemberService.loadClubMembers().subscribe((clubMembers: ClubMember[]) => {
      this.clubMembers = clubMembers;
    });
  }

  getClubMember(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (isNumeric(id)) {
      this.isNew = false;
    }
    this.clubMemberService.getClubMember(id as unknown as number)
      .subscribe(clubMember => {
        console.log(clubMember)
        console.log(typeof clubMember.clubMemberBirthday)
        this.clubMember = {
          ...clubMember,
          clubMemberBirthday: new Date(clubMember.clubMemberBirthday),
          entranceDate: new Date(clubMember.entranceDate),
          exitDate: new Date(clubMember.exitDate),
          terminationDate: new Date(clubMember.terminationDate)
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

  updateClubMember(clubMember: ClubMember): void {
    if (clubMember.clubMemberName && clubMember.clubMemberAdress && clubMember.clubMemberBirthday && clubMember.entranceDate && clubMember.iban && clubMember.membership_type) {
      if (this.isNew) {
        console.log("Mitgliedsname: " + clubMember.clubMemberName)
        console.log("club Member ID alt: " + clubMember.clubMemberId)

        clubMember.clubMemberId = this.generateClubMemberId()

        console.log("club Member ID generiert: " + clubMember.clubMemberId)
        this.clubMemberService.createClubMember(clubMember).subscribe();
      } else {
        if (this.validExitDate(clubMember.exitDate)) {
          if (this.validTerminationDateAndExitDateCombination(clubMember.terminationDate, clubMember.exitDate)) {
            this.clubMemberService.updateClubMember(clubMember).subscribe();
          }
        } else {
          alert("Austrittsdatum muss zum Jahresende (31.12) sein! Änderungen wurden nicht gespeichert.");
        }
      }
    } else if (!clubMember.clubMemberName) {
      alert("Kein Name angegeben! Änderungen wurden nicht gespeichert.");
    } else if (!clubMember.clubMemberAdress) {
      alert("Keine Adresse angegeben! Änderungen wurden nicht gespeichert.");
    } else if (!clubMember.clubMemberBirthday) {
      alert("Kein Geburstdatum angegeben! Änderungen wurden nicht gespeichert.");
    } else if (!clubMember.entranceDate) {
      alert("Kein Eintrittsdatum angegeben! Änderungen wurden nicht gespeichert.");
    } else if (!clubMember.iban) {
      alert("Keine IBAN angegeben! Änderungen wurden nicht gespeichert.");
    }else {
      alert("Keine Mitgliedsart angegeben! Änderungen wurden nicht gespeichert.");
    }

  }

  generateClubMemberId(): number {
    let defaultValue = 9999;
    let index = 1;
    let list: number[] = []

    for (let existingClubMember of this.clubMembers) {
      list.push(existingClubMember.clubMemberId)
    }

    for (let investigatedId in this.clubMembers) {
      index++;
      if (!list.includes(index)) {
        return this.clubMember.clubMemberId = index
      }
    }
    return defaultValue
  }

  validTerminationDateAndExitDateCombination(terminationDate: Date, exitDate: Date): boolean {

    console.log(terminationDate.toString().substring(5, 7))

    if (terminationDate.toString().substring(0, 4) != exitDate.toString().substring(0, 4)) {
      console.log("Invalid combination")
      alert("Austrittsjahr entspricht nicht dem Kündigungsjahr oder es wurde kein Kündigungsdatum, bzw. Austrittsdatum erfasst.")
      return false
    }
    else if (terminationDate.toString().substring(5, 7) != "10" && terminationDate.toString().substring(5, 7) != "11" && terminationDate.toString().substring(5, 7) != "12") {
      console.log("Invalid combination")
      return true
    } else {
      alert("3 Monatige Kündigungsfrist zum Jahresende beachten")
      return false
    }

    return false

  }

  validExitDate(date: Date): boolean {

    console.log("validate date string: " + date.toString().substring(8, 15))

    if (date.toString().substring(5, 10) == "12-31" || date.toString().substring(8, 15) == "01 1970") {
      return true
    } else {
      return false
    }
  }


}
