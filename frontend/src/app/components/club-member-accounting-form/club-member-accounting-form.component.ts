import {Component, OnInit} from '@angular/core';
import {AnnualPayment} from "../../model/annualPayment";
import {ActivatedRoute} from "@angular/router";
import {AnnualPaymentService} from "../../services/annual-payment.service";
import {ClubMember} from "../../model/clubMember";

@Component({
  selector: 'app-club-member-accounting-form',
  templateUrl: './club-member-accounting-form.component.html',
  styleUrls: ['./club-member-accounting-form.component.css']
})
export class ClubMemberAccountingFormComponent implements OnInit {
  annualPayments: AnnualPayment[] = [];

  annualPayment: AnnualPayment = {
    annualPaymentId: 0,
    clubMemberId: 0,
    annualPaymentYear: 0,
    annualPaymentFee: 0,
    annualPaymentPaidFee: 0
  }

  constructor(private route: ActivatedRoute, private annualPaymenService: AnnualPaymentService) {
  }

  ngOnInit(): void {
    this.getAnnualPayment();
    this.getAnnualPayments();
  }

  getAnnualPayment(){

  }

  getAnnualPayments(){
    const id = this.route.snapshot.paramMap.get('id');

    this.annualPaymenService.loadAnnualPayments(id as unknown as number).subscribe((annualPayment: AnnualPayment[]) => {
      this.annualPayments = annualPayment;
    });
  }

}
