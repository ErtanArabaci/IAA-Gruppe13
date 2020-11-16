import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ClubMember} from "../model/clubMember";
import {AnnualPayment} from "../model/annualPayment";

@Injectable({
  providedIn: 'root'
})
export class AnnualPaymentService {

  constructor(private http: HttpClient) { }

  loadAnnualPayments(id: number): Observable<AnnualPayment[]> {
    return this.http.get<AnnualPayment[]>('/rest/annual-payments/' + id);
  }
}
