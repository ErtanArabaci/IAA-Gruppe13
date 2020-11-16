import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {ClubMember} from "../model/clubMember";


@Injectable({
  providedIn: 'root'
})
/**
 * The implementation of a service that cancel, create, update and delete club members
 *
 * @author Kim Bartikowski, Ertan Arabaci, Torben Labs
 *
 */
export class ClubMemberService {

  constructor(private http: HttpClient) {
  }

  /**
   * creates a club member
   *
   * @param clubMember an empty club member
   * @return ClubMember
   */
  createClubMember(clubMember: ClubMember) {
    return this.http.post<ClubMember>('/rest/club-members', clubMember)
  }

  /**
   * loads all club members that are saved
   *
   * @return a list of all club members
   */
  loadClubMembers(): Observable<ClubMember[]> {
    return this.http.get<ClubMember[]>('/rest/club-members');
  }

  /**
   * gets an empty club member
   *
   * @return an empty club member
   */
  getEmptyClubMember(): Observable<ClubMember> {
    return this.http.get<ClubMember>('/rest/empty-club-member')
  }

  /**
   * get specific club member by id
   *
   * @param id the id of the club member that is to be returned
   * @return the club member with given id
   */
  getClubMember(id: number): Observable<ClubMember> {
    return this.http.get<ClubMember>('/rest/club-member-form/' + id);
  }

  /**
   * gets club member by id for the accounting overview
   *
   * @param id the id of the club member that is to be returned
   * @return the club member with given id
   */
  getClubMemberAccounting(id: number): Observable<ClubMember> {
    return this.http.get<ClubMember>('/rest/club-member-accounting/' + id);
  }

  /**
   * updates the attributes of a given club member
   *
   * @param clubMember the club member that is to be updated
   * @return the updated club member
   */
  updateClubMember(clubMember: ClubMember): Observable<ClubMember> {
    return this.http.put<ClubMember>(`/rest/club-members`, clubMember)
  }

  /**
   * deletes a club member by given id
   *
   * @param id id of the club member that is to be deleted
   * @return a Http response based on the club member id
   */
  deleteClubMember(id: number): Observable<HttpResponse<void>> {
    return this.http.delete<void>(`/rest/club-members/${id}`, {observe: 'response'});
  }

}
