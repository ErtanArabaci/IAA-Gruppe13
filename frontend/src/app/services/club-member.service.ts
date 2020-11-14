import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ClubMember} from "../model/clubMember";


@Injectable({
  providedIn: 'root'
})
export class ClubMemberService {

  constructor(private http: HttpClient) {
  }

  loadClubMembers(): Observable<ClubMember[]> {
    return this.http.get<ClubMember[]>('/rest/club-members');
  }

  getClubMember(id: number): Observable<ClubMember> {
    return this.http.get<ClubMember>('/rest/club-member-form/' + id);
  }

  updateClubMember(clubMember: ClubMember){
    console.log("Update Member " + clubMember.clubMemberId + "with name " + clubMember.clubMemberName +  "pls")
    return this.http.put<ClubMember>('/rest/club-member-form/' + clubMember.clubMemberId, clubMember)
  }

  deleteClubMember(id: number) {

    console.log("delete member " + id + " pls");
    return this.http.delete<ClubMember>('rest/club-member-form/' + id)
  }


}
