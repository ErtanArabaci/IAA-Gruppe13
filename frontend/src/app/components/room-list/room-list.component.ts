import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Room} from "../../model/room";

@Component({
  selector: 'app-room-list',
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {
  @Input() rooms: Room[] = [];
  @Output() selectRoom = new EventEmitter<Room>();

  constructor() { }

  ngOnInit(): void {
  }

  onSelect(room: Room): void {
    this.selectRoom.emit(room);
  }
}
