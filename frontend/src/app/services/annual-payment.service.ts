import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {ClubMember} from "../model/clubMember";
import {AnnualPayment} from "../model/annualPayment";

@Injectable({
  providedIn: 'root'
})
export class AnnualPaymentService {

  constructor(private http: HttpClient) {
  }

  loadAnnualPayments(id: number): Observable<AnnualPayment[]> {
    return this.http.get<AnnualPayment[]>('/rest/annual-payments/club-member/' + id);
  }

  getAnnualPayment(id: number): Observable<AnnualPayment> {
    return this.http.get<AnnualPayment>('/rest/annual-payments/' + id);
  }

  getAnnualPaymentForNewAnnualPayment(id: number): Observable<AnnualPayment> {
    return this.http.get<AnnualPayment>('/rest/annual-payments/new/' + id);
  }

  createAnnualPayment(annualPayment: AnnualPayment) {
    return this.http.post<AnnualPayment>('/rest/annual-payments', annualPayment)
  }

  updateAnnualPayment(annualPayment: AnnualPayment): Observable<AnnualPayment> {
    return this.http.put<AnnualPayment>(`/rest/annual-payments`, annualPayment)
  }

  deleteAnnualPayment(id: number): Observable<HttpResponse<void>> {
    return this.http.delete<void>(`/rest/annual-payments/${id}`, {observe: 'response'});
  }

}
