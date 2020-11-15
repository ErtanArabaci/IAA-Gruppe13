import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {ClubMemberFormComponent} from "./components/club-member-form/club-member-form.component";
import {ClubMemberListComponent} from "./components/club-member-list/club-member-list.component";
import {ClubMemberAccountingComponent} from "./components/club-member-accounting/club-member-accounting.component";
import {ClubMemberCreateFormComponent} from "./components/club-member-create-form/club-member-create-form.component";

const routes: Routes = [
  {path: 'club-member-form/:id', component: ClubMemberFormComponent},
  {path: 'club-member-form', component: ClubMemberFormComponent},
  {path: 'club-member-list', component: ClubMemberListComponent},
  {path: 'club-member-accounting', component: ClubMemberAccountingComponent},
  {path: 'club-member-accounting/:id', component: ClubMemberAccountingComponent},
  {path: 'club-member-create-form', component: ClubMemberCreateFormComponent},
  {path:'', redirectTo:'club-member-list', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class ClubMemberAppRoutingModule {
}
