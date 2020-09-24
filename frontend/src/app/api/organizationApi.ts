import {Injectable} from '@angular/core';
import {ApiService} from './api-connector';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrganizationApi {

  constructor(private apiService: ApiService) {
  }

  getOrganizations(): Observable<string> {
    return this.apiService.get('/organization/getAll');
  }
}
