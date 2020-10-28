import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ClubMemberAppComponent} from './club-member-app.component';
import {AppModule} from "./app.module";
import {ClubMemberListComponent} from "./components/club-member-list/club-member-list.component";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {ClubMembersComponent} from './components/club-members/club-members.component';
import {ClubMemberFormComponent} from './components/club-member-form/club-member-form.component';


@NgModule({
  declarations: [
    ClubMemberAppComponent,
    ClubMemberListComponent,
    ClubMembersComponent,
    ClubMemberFormComponent
  ],
  imports: [
    CommonModule,
    AppModule,
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  exports: [],
  bootstrap: [ClubMemberAppComponent]
})
export class ClubMemberAppModule { }