import { Component, OnInit } from '@angular/core';
import {OrganizationDto} from '../../../dto/organizationDto';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {OrganizationApi} from '../../../api/organizationApi';
import {Globals} from '../../../globals';

export enum OrganizationCreatorComponentType {
  New,
  Update
}

@Component({
  selector: 'app-organization-creator',
  templateUrl: './organization-creator.component.html',
  styleUrls: ['./organization-creator.component.css']
})
export class OrganizationCreatorComponent implements OnInit {
  panelOpenState: boolean;
  init = true;
  public type: OrganizationCreatorComponentType = OrganizationCreatorComponentType.New;

  org: OrganizationDto;
  orgForm: FormGroup;

  public onSubmission: (caller: OrganizationCreatorComponent) => void = null;

  constructor(private organizationService: OrganizationApi, private globals: Globals) { }

  ngOnInit(): void {
    this.resetForm();
  }

  resetForm(): void {
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

    this.init = true;
  }

  setFormElements(organization: OrganizationDto): void {
    this.orgForm.setValue({
      name: organization.name,
      website: organization.website,
    });
    this.org.id = organization.id;
  }

  get name() { return this.orgForm.get('name'); }
  get website() { return this.orgForm.get('website'); }

  submitForm(): void {
    this.init = false;
    this.org.name = this.name.value;
    this.org.website = this.website.value;
    this.organizationService.addOrganization(this.org).subscribe(event => {
      if (this.onSubmission != null) {
        this.onSubmission(this);
      }
    });
  }

  isChecked(): boolean {
    return this.globals.checked.getValue();
  }

}
