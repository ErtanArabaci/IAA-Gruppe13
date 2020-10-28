import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ClubMember} from "../model/clubMember";

@Injectable({
  providedIn: 'root'
})
export class ClubMemberService {

  constructor(private http: HttpClient) { }

  loadClubMembers(): Observable<ClubMember[]>{
    return this.http.get<ClubMember[]>('/rest/club-members');
  }

  updateClubMembers(clubMember: ClubMember): Observable<void>{
    return this.http.put<void>('/rest/rooms/$clubMember.clubMemberId}' , clubMember);
  }
}
