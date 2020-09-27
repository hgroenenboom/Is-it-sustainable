import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {OrganizationComponent} from './components/items/organization/organization.component';
import {OrganizationListComponent} from './components/organization-list/organization-list.component';
import {AppComponent} from './app.component';

const routes: Routes = [
  { path: '', component: OrganizationListComponent },
  { path: 'home', component: OrganizationListComponent },
  { path: 'organization', component: OrganizationComponent },
  { path: 'organization-list', component: OrganizationListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
