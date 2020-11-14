import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {ClubMember} from "../model/clubMember";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ClubMemberService {

  constructor(private http: HttpClient) {
  }

  createClubMember(clubMember: ClubMember){
    return this.http.post<ClubMember>('/rest/club-member-form/' + clubMember.clubMemberId, clubMember, httpOptions)
  }

  loadClubMembers(): Observable<ClubMember[]> {
    return this.http.get<ClubMember[]>('/rest/club-members');
  }

  getClubMember(id: number): Observable<ClubMember> {
    return this.http.get<ClubMember>('/rest/club-member-form/' + id);
  }

  updateClubMember(clubMember: ClubMember){
    console.log("Update Member " + clubMember.clubMemberId + " with name " + clubMember.clubMemberName +  "pls")
    return this.http.put<ClubMember>('/rest/club-member-form/' + clubMember.clubMemberId, clubMember,  httpOptions)
  }

  deleteClubMember(id: number): Observable<ClubMember>{
    console.log("delete member " + id + " pls");
    return this.http.delete<ClubMember>('rest/club-members/' + id)
  }


}
