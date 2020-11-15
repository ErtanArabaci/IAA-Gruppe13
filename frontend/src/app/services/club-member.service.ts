import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {ClubMember} from "../model/clubMember";


@Injectable({
  providedIn: 'root'
})
export class ClubMemberService {

  constructor(private http: HttpClient) {
  }

  createClubMember(clubMember: ClubMember) {
    return this.http.post<ClubMember>('/rest/club-members', clubMember)
  }

  loadClubMembers(): Observable<ClubMember[]> {
    return this.http.get<ClubMember[]>('/rest/club-members');
  }

  getEmptyClubMember(): Observable<ClubMember>{
    return this.http.get<ClubMember>('/rest/empty-club-member')
  }

  getClubMember(id: number): Observable<ClubMember> {
    return this.http.get<ClubMember>('/rest/club-member-form/' + id);
  }

  getClubMemberAccounting(id: number): Observable<ClubMember> {
    return this.http.get<ClubMember>('/rest/club-member-accounting/' + id);
  }


  updateClubMember(clubMember: ClubMember): Observable<ClubMember> {
    console.log("Update Member " + clubMember.clubMemberId + " with name " + clubMember.clubMemberName + "pls")
    console.log("Birthday Date: " +clubMember.clubMemberBirthday);
    return this.http.put<ClubMember>(`/rest/club-members`, clubMember)
  }

  deleteClubMember(id: number): Observable<HttpResponse<void>> {
    console.log("delete member " + id + " pls");
    console.log(`/rest/club-members/${id}`);
    return this.http.delete<void>(`/rest/club-members/${id}`, {observe: 'response'});
  }


}
