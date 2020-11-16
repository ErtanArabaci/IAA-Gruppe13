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
  allAnnualPayments: AnnualPayment[] = [];

  annualPayment: AnnualPayment = {
    annualPaymentId: 0,
    clubMemberId: 0,
    annualPaymentYear: 2020,
    annualPaymentFee: 0,
    annualPaymentPaidFee: 0
  }

  @Output() cancel = new EventEmitter();
  @Output() save = new EventEmitter<AnnualPayment>();
  isNew: boolean = true;

  constructor(private route: ActivatedRoute, private annualPaymentService: AnnualPaymentService) {
  }

  ngOnInit(): void {
    this.getAnnualPayments();
    this.getAnnualPayment();
  }

  getAnnualPayments() {
    const id = this.route.snapshot.paramMap.get('id');
    this.annualPaymentService.loadAnnualPayments(id as unknown as number).subscribe((annualPayments: AnnualPayment[]) => {
      this.annualPayments = annualPayments;
    });
  }

  getAllAnnualPayments(){
    this.annualPaymentService.loadAllAnnualPayments().subscribe((allAnnualPayments: AnnualPayment[]) => {
      this.allAnnualPayments = allAnnualPayments;
    });
  }


  getAnnualPayment(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (isNumeric(id)) {
      this.isNew = false;
    }
    this.annualPaymentService.getAnnualPayment(id as unknown as number)
      .subscribe(annualPayment => {
        this.annualPayment = {
          ...annualPayment,
        }
      });

  }

  deleteAnnualPayment(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.annualPaymentService.deleteAnnualPayment(id as unknown as number).subscribe();
  }

  onCancel(): void {
    this.cancel.emit();
  }

  updateAnnualPayment(annualPayment: AnnualPayment): void {
    if (annualPayment.annualPaymentYear && annualPayment.annualPaymentFee && annualPayment.annualPaymentPaidFee) {
      if (this.isNew) {
        annualPayment.annualPaymentId = this.generateAnnualPaymentId();
        this.annualPaymentService.getAnnualPayment(this.annualPayment.clubMemberId);

        this.annualPaymentService.createAnnualPayment(annualPayment).subscribe();
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
    this.getAllAnnualPayments()
    let defaultValue = 9999;
    console.log(this.allAnnualPayments)
    try {
      let lastId = this.allAnnualPayments[this.allAnnualPayments.length - 1].annualPaymentId;
      lastId ++;
      return  lastId
    }
    catch{
      return defaultValue
    }
  }

}
