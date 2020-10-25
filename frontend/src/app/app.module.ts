import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RoomListComponent } from './components/room-list/room-list.component';
import { RoomsComponent } from './components/rooms/rooms.component';
import {HttpClientModule} from "@angular/common/http";
import { RoomFormComponent } from './components/room-form/room-form.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    RoomListComponent,
    RoomsComponent,
    RoomFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
