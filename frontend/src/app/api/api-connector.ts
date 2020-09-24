import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpRequest, HttpResponse} from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import {catchError, filter, map, retry} from 'rxjs/operators';
// import {serialize} from 'v8';

export enum RequestMethod {
  Get = 'GET',
  Head = 'HEAD',
  Post = 'POST',
  Put = 'PUT',
  Delete = 'DELETE',
  Options = 'OPTIONS',
  Patch = 'PATCH'
}

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  url = 'http://localhost:8082';
  headers = new HttpHeaders({
  });

  constructor(private http: HttpClient) { }

  get(path: string, args?: any): Observable<any> {
    console.log('inside GET');

    if (args) {
      // options.params = serialize(args);
    }

    return this.http.get(this.url + path, { withCredentials: false, responseType: 'text' })
      .pipe(catchError(this.checkError.bind(this)));
  }

  private checkError(error: any): any {
    if (error && error.status === 401) {
    } else {
    }
    throw error;
  }
}
