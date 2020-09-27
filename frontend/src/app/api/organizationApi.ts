import {Injectable} from '@angular/core';
import {ApiService} from './api-connector';
import {Observable} from 'rxjs';
import {getWebpackStatsConfig} from '@angular-devkit/build-angular/src/angular-cli-files/models/webpack-configs';
import {OrganizationDto} from '../dto/organizationDto';
import {OrganizationTagDto} from '../dto/OrganizationTagDto';

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

  getOrganizationNamesByIds(ids: number[]): Observable<string[]> {
    const strings = this.apiService.get(this.path + 'getNamesById?ids', { ids } );
    return strings;
  }

  getOrganizationsByName(name: string): Observable<OrganizationDto[]> {
    return this.apiService.get(this.path + 'findByName', { name });
  }

  getTagNames(): Observable<OrganizationTagDto[]> {
    return this.apiService.get(this.path + 'getTags');
  }

  getTagsByName(name: string): Observable<OrganizationTagDto[]> {
    return this.apiService.get(this.path + 'findTagByTagName', { name });
  }
}
