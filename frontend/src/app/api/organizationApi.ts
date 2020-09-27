import {Injectable} from '@angular/core';
import {ApiService} from './api-connector';
import {Observable} from 'rxjs';
import {getWebpackStatsConfig} from '@angular-devkit/build-angular/src/angular-cli-files/models/webpack-configs';
import {OrganizationDto} from '../dto/organizationDto';

@Injectable({
  providedIn: 'root'
})
export class OrganizationApi {
  path = '/organization/';

  constructor(private apiService: ApiService) {
  }

  getOrganizations(): Observable<string> {
    return this.apiService.get(this.path + 'getAll');
  }

  addOrganization(organization: OrganizationDto): Observable<any> {
    return this.apiService.post(this.path + 'save', JSON.parse(JSON.stringify(organization)), null);
  }

  getOrganizationById(id: number): Observable<OrganizationDto> {
    return this.apiService.get(this.path + 'getById', { id } );
  }
}
