import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Room} from "../../model/room";

@Component({
  selector: 'app-room-form',
  templateUrl: './room-form.component.html',
  styleUrls: ['./room-form.component.css']
})
export class RoomFormComponent implements OnInit {
  @Input() room!: Room;

  @Output() cancel = new EventEmitter();
  @Output() save = new EventEmitter<Room>();


  constructor() { }

  ngOnInit(): void {
  }

  onCancel(): void {
    this.cancel.emit();
  }

  onSave(): void {
    this.save.emit(this.room);
  }
}
