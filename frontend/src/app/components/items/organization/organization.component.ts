import {Component, Input, OnInit} from '@angular/core';
import {OrganizationDto} from '../../../dto/organizationDto';
import {ActivatedRoute} from '@angular/router';
import {OrganizationApi} from '../../../api/organizationApi';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-organization',
  templateUrl: './organization.component.html',
  styleUrls: ['./organization.component.css']
})
export class OrganizationComponent implements OnInit {
  organization: OrganizationDto;
  subscription: Subscription;

  constructor(private route: ActivatedRoute, private orgService: OrganizationApi) {
    this.organization = new OrganizationDto(null, null, null, null);
    const that = this;
    this.subscription = this.route.queryParams.subscribe(params => {
      orgService.getOrganizationById(params.id).subscribe(event => {
        if (event) {
          that.organization.id = event.id ? event.id : null;
          that.organization.name = event.name ? event.name : null;
          that.organization.partnerIds = event.partnerIds ? event.partnerIds : null;
          that.organization.website = event.website ? event.website : null;
        }
      });
    });
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
