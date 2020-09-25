import {Component, Input} from '@angular/core';
import {OrganizationApi} from './api/organizationApi';
import {OrganizationDto} from './dto/organizationDto';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'IsItSustainable';

  @Input()
  orgs: OrganizationDto[];

  constructor(private organizationService: OrganizationApi) {
    organizationService.getOrganizations().subscribe(
      (event) => {
        this.orgs = [];

        for (let i = 0; i < event.length; i++) {
          const e = event[i];
          // @ts-ignore
          this.orgs[i] = new OrganizationDto(e.id, e.name, e.website, e.partnerIds);
        }
      }
    );

    // organizationService.addOrganization(new OrganizationDto(null, 'test', 'www.nl', null)).subscribe();
  }

}
