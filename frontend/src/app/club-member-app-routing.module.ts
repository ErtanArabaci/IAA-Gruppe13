import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {ClubMemberFormComponent} from "./components/club-member-form/club-member-form.component";
import {ClubMemberListComponent} from "./components/club-member-list/club-member-list.component";
import {ClubMembersComponent} from "./components/club-members/club-members.component";
import {ClubMemberAccountingComponent} from "./components/club-member-accounting/club-member-accounting.component";

const routes: Routes = [
  {path: 'club-member-form/:id', component: ClubMemberFormComponent},
  {path: 'club-member-form', component: ClubMemberFormComponent},
  {path: 'club-members', component: ClubMembersComponent},
  {path: 'club-member-list', component: ClubMemberListComponent},
  {path: 'club-member-accounting', component: ClubMemberAccountingComponent},
  {path: 'club-member-accounting/:id', component: ClubMemberAccountingComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class ClubMemberAppRoutingModule {
}
