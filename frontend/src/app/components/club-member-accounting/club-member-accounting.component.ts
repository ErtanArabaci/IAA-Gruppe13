import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ClubMember} from "../../model/clubMember";
import {ActivatedRoute} from "@angular/router";
import {ClubMemberService} from "../../services/club-member.service";
import {AnnualPayment} from "../../model/annualPayment";
import {AnnualPaymentService} from "../../services/annual-payment.service";

@Component({
  selector: 'app-club-member-accounting',
  templateUrl: './club-member-accounting.component.html',
  styleUrls: ['./club-member-accounting.component.css']
})
export class ClubMemberAccountingComponent implements OnInit {
  clubMember!: ClubMember;
  annualPayments: AnnualPayment[] = [];

  @Output() selectClubMember = new EventEmitter<ClubMember>();
  term: any;

  constructor(
    private route: ActivatedRoute,
    private clubMemberService: ClubMemberService,
    private annualPaymentService: AnnualPaymentService
  ) {
  }

  ngOnInit(): void {
    this.getClubMemberAccounting();
    this.getAnnualPayments();
  }

  getClubMemberAccounting(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.clubMemberService.getClubMemberAccounting(id as unknown as number)
      .subscribe(clubMember => {
        this.clubMember = clubMember;
      });
  }

  getAnnualPayments() {
    const id = this.route.snapshot.paramMap.get('id');
    this.annualPaymentService.loadAnnualPayments(id as unknown as number).subscribe((annualPayments: AnnualPayment[]) => {
      this.annualPayments = annualPayments;
    });
  }

}
