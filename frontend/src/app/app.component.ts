import {Component, Input} from '@angular/core';
import {OrganizationApi} from './api/organizationApi';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'IsItSustainable';

  @Input()
  orgs: string;

  constructor(private organizationService : OrganizationApi) {
    organizationService.getOrganizations().subscribe(
      (event) => {
        this.orgs = event;
      }
    );
  }
}
