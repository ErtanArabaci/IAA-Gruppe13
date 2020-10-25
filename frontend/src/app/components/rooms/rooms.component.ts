import { Component, OnInit } from '@angular/core';
import {Room} from "../../model/room";
import {RoomService} from "../../services/room.service";

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css']
})
export class RoomsComponent implements OnInit {
  rooms: Room[] = [];
  selectedRoom?: Room;

  constructor(private roomService: RoomService) { }

  ngOnInit(): void {
    this.reloadRoomList();
  }

  private reloadRoomList() {
    this.roomService.loadRooms().subscribe((rooms: Room[]) => {
      this.rooms = rooms;
    });
  }

  onSelectRoom(room: Room): void {
    this.selectedRoom = {...room};
  }

  onCancelEdit() {
    this.selectedRoom = undefined;
  }

  onSave(room: Room) {
    this.roomService.updateRoom(room).subscribe( () => {
      this.selectedRoom = undefined;
      this.reloadRoomList();
    } )
  }
}
