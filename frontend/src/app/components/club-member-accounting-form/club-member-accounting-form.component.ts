import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AnnualPayment} from "../../model/annualPayment";
import {ActivatedRoute} from "@angular/router";
import {AnnualPaymentService} from "../../services/annual-payment.service";
import {ClubMember} from "../../model/clubMember";
import {isNumeric} from "rxjs/internal-compatibility";

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

  @Output() cancel = new EventEmitter();
  @Output() save = new EventEmitter<AnnualPayment>();
  isNew: boolean = true;

  constructor(private route: ActivatedRoute, private annualPaymenService: AnnualPaymentService) {
  }

  ngOnInit(): void {
    this.getAnnualPayment();
    this.getAnnualPayments();
  }

  getAnnualPayments() {
    const id = this.route.snapshot.paramMap.get('id');

    this.annualPaymenService.loadAnnualPayments(id as unknown as number).subscribe((annualPayment: AnnualPayment[]) => {
      this.annualPayments = annualPayment;
    });
  }


  getAnnualPayment(): void {
    console.log("Initiales Jahr: " + this.annualPayment.annualPaymentYear)
    const id = this.route.snapshot.paramMap.get('id');
    if (isNumeric(id)) {
      this.isNew = false;
    }
    this.annualPaymenService.getAnnualPayment(id as unknown as number)
      .subscribe(annualPayment => {
        this.annualPayment={
          ...annualPayment
        }
      });

    console.log("Jahr von geladener Zahlung::  " + this.annualPayment.annualPaymentYear)

  }

  deleteAnnualPayment(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.annualPaymenService.deleteAnnualPayment(id as unknown as number).subscribe();
  }

  onCancel(): void {
    this.cancel.emit();
  }

  updateAnnualPayment(annualPayment: AnnualPayment): void {
    if (annualPayment.annualPaymentYear && annualPayment.annualPaymentFee && annualPayment.annualPaymentPaidFee) {
      if (this.isNew) {
        annualPayment.annualPaymentId = this.generateAnnualPaymentId();

        this.annualPaymenService.createAnnualPayment(annualPayment).subscribe();
      } else {
        if (this.validAnnualPaymentYear(annualPayment.annualPaymentYear)) {
          this.annualPaymenService.updateAnnualPayment(annualPayment).subscribe();
        } else {
          alert("Zahlung im Jahr " + annualPayment.annualPaymentYear + " bereits vorhanden");
        }
      }
    } else if (!annualPayment.annualPaymentYear) {
      alert("Kein Jahr angegeben! Änderungen wurden nicht gespeichert.");
    } else if (!annualPayment.annualPaymentFee) {
      alert("Kein Beitrag angegeben! Änderungen wurden nicht gespeichert.");
    } else {
      alert("Keine Zahlung angegeben! Änderungen wurden nicht gespeichert.");
    }
  }

  generateAnnualPaymentId(): number {
    let defaultValue = 9999;
    let index = 1;
    let list: number[] = []

    for (let existingAnnualPayment of this.annualPayments) {
      list.push(existingAnnualPayment.annualPaymentId)
    }

    for (let investigatedId in this.annualPayments) {
      index++;
      if (!list.includes(index)) {
        return this.annualPayment.annualPaymentId = index
      }
    }
    return defaultValue
  }

  private validAnnualPaymentYear(annualPaymentYear: number) {
    return true;
  }
}
