import { Injectable } from '@angular/core';
import {Room} from "../model/room";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private http: HttpClient) { }

  loadRooms(): Observable<Room[]> {
    return this.http.get<Room[]>(  '/rest/rooms');
  }

  updateRoom(room: Room): Observable<void> {
    return this.http.put<void>(`/rest/rooms/${room.id}`, room);
  }
}
