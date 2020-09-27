import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {OrganizationDto} from '../../dto/organizationDto';
import {OrganizationApi} from '../../api/organizationApi';

import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {Globals} from '../../globals';
import {
  OrganizationCreatorComponent,
  OrganizationCreatorComponentType
} from '../creators/organization-creator/organization-creator.component';
import { ElementRef } from '@angular/core';

@Component({
  selector: 'app-organization-list',
  templateUrl: './organization-list.component.html',
  styleUrls: ['./organization-list.component.css']
})
export class OrganizationListComponent implements OnInit {
  @Input()
  orgs: OrganizationDto[];

  oldUpdateButton: ElementRef = null;
  @ViewChild('updater') updater: OrganizationCreatorComponent;
  @ViewChild('creator') creator: OrganizationCreatorComponent;

  constructor(private organizationService: OrganizationApi, private router: Router, private globals: Globals) {
    this.updateOrganizations();
  }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    const that = this;
    this.updater.type = OrganizationCreatorComponentType.Update;
    this.updater.onSubmission = (caller) => {
      const updater = document.getElementById('updater');
      updater.classList.add('d-none');
      caller.resetForm();
    };
    this.creator.onSubmission = (caller) => {
    };
  }

  isEditMode(): boolean {
    return this.globals.checked.getValue();
  }

  showUpdater(event, org: OrganizationDto) {
    if (this.oldUpdateButton) {
      this.oldUpdateButton.nativeElement.classList.remove('d-none');
    }

    const button = event.target || event.srcElement || event.currentTarget;
    const parent = button.parentNode;

    this.updater.setFormElements(org);

    const updater = document.getElementById('updater');
    parent.appendChild(updater);
    updater.classList.remove('d-none');

    this.oldUpdateButton = new ElementRef(button);
    this.oldUpdateButton.nativeElement.classList.add('d-none');
  }

  private updateOrganizations(): void {
    this.organizationService.getOrganizations().subscribe(
      (event) => {
        this.orgs = [];

        for (let i = 0; i < event.length; i++) {
          const e = event[i];
          // @ts-ignore
          this.orgs[i] = new OrganizationDto(e.id, e.name, e.website, e.partnerIds, e.organizationTags);
        }
      }
    );
  }
}
