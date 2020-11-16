import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {AnnualPayment} from "../model/annualPayment";

@Injectable({
  providedIn: 'root'
})
/**
 * The implementation of a service that cancel, create, update and delete annual payments
 *
 * @author Kim Bartikowski, Ertan Arabaci, Torben Labs
 *
 */
export class AnnualPaymentService {

  constructor(private http: HttpClient) {
  }

  /**
   * loads all annual payments
   *
   * @return annualPayment a list of all annual payments
   */
  loadAllAnnualPayments(): Observable<AnnualPayment[]> {
    return this.http.get<AnnualPayment[]>('/rest/annual-payments');
  }

  /**
   * loads all annual payments of an club member
   *
   * @return annualPayment a list of all annual payments from a club member
   */
  loadAnnualPayments(id: number): Observable<AnnualPayment[]> {
    return this.http.get<AnnualPayment[]>('/rest/annual-payments/club-member/' + id);
  }

  /**
   * loads annual payment with a specific id
   *
   * @return annualPayment a list of all annual payments
   */
  getAnnualPayment(id: number): Observable<AnnualPayment> {
    return this.http.get<AnnualPayment>('/rest/annual-payments/' + id);
  }

  /**
   * creates an annual Payment
   *
   * @param annualPayment an empty annual Payment
   */
  createAnnualPayment(annualPayment: AnnualPayment) {
    return this.http.post<AnnualPayment>('/rest/annual-payments', annualPayment)
  }

  /**
   * updates the attributes of a given annual payment
   *
   * @param annualPayment the annual payment that is to be updated
   * @return the updated annual payment
   */
  updateAnnualPayment(annualPayment: AnnualPayment): Observable<AnnualPayment> {
    return this.http.put<AnnualPayment>(`/rest/annual-payments`, annualPayment)
  }

  /**
   * deletes an annual payment by given id
   *
   * @param  id of the annual payment that is to be deleted
   * @return a Http response based on the annual payment id
   */
  deleteAnnualPayment(id: number): Observable<HttpResponse<void>> {
    return this.http.delete<void>(`/rest/annual-payments/${id}`, {observe: 'response'});
  }

}
