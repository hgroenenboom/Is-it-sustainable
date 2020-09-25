import {Component, Input} from '@angular/core';
import {OrganizationApi} from './api/organizationApi';
import {OrganizationDto} from './dto/organizationDto';
import {FormControl, FormGroup, NgForm, Validators} from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'IsItSustainable';

  @Input()
  orgs: OrganizationDto[];

  init = true;
  org: OrganizationDto;
  orgForm: FormGroup;

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

  ngOnInit(): void {
    this.org = new OrganizationDto(null, null, null, null);

    this.orgForm = new FormGroup({
      name: new FormControl(this.org.name, [
        Validators.required,
        Validators.minLength(1)
      ]),
      website: new FormControl(this.org.website, [
        Validators.required,
        Validators.minLength(1)
      ])
    });
  }

  get name() { return this.orgForm.get('name'); }
  get website() { return this.orgForm.get('website'); }

  submitForm(): void {
    this.init = false;
    this.org.name = this.name.value;
    this.org.website = this.website.value;
    this.organizationService.addOrganization(this.org).subscribe(event => {
      console.log(event);
    });
  }

}
