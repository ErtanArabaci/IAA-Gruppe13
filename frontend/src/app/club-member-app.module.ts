import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ClubMemberAppComponent} from './club-member-app.component';
import {AppModule} from "./app.module";
import {ClubMemberListComponent} from "./components/club-member-list/club-member-list.component";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {ClubMemberFormComponent} from './components/club-member-form/club-member-form.component';
import {ClubMemberAppRoutingModule} from './club-member-app-routing.module';
import {Ng2SearchPipeModule} from "ng2-search-filter";
import { ClubMemberAccountingComponent } from './components/club-member-accounting/club-member-accounting.component';
import { NavComponent } from './components/nav/nav.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { MatIconModule } from '@angular/material/icon';
import { ClubMemberCreateFormComponent } from './components/club-member-create-form/club-member-create-form.component';


@NgModule({
  declarations: [
    ClubMemberAppComponent,
    ClubMemberListComponent,
    ClubMemberFormComponent,
    ClubMemberAccountingComponent,
    NavComponent,
    ClubMemberCreateFormComponent,
  ],
  imports: [
    CommonModule,
    AppModule,
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ClubMemberAppRoutingModule,
    Ng2SearchPipeModule,
    BrowserAnimationsModule,
    MatIconModule,
  ],
  providers: [],
  exports: [],
  bootstrap: [ClubMemberAppComponent]
})
export class ClubMemberAppModule { }
