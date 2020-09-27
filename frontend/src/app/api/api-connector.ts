import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, HttpRequest, HttpResponse} from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import {catchError, filter, map, retry} from 'rxjs/operators';

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
    const x = args ? JSON.parse(JSON.stringify(args)) : {};
    return this.http.get(this.url + path, { withCredentials: false, responseType: 'json', params: x })
      .pipe(catchError(this.checkError.bind(this)));
  }

  post(path: string, body: any, customHeaders?: HttpHeaders): Observable<any> {
    return this.request(path, body, RequestMethod.Post, customHeaders);
  }

  private request(path: string, body: any, method = RequestMethod.Post, custemHeaders?: HttpHeaders): Observable<any> {
    const req = new HttpRequest(method, this.url + path, body, { withCredentials: false, responseType: 'json' });

    return this.http.request(req).pipe(filter(response => response instanceof HttpResponse))
      .pipe(map((response: HttpResponse<any>) => response.body))
      .pipe(catchError(error => this.checkError(error)));
  }

  private checkError(error: any): any {
    if (error && error.status === 401) {
    } else {
    }
    throw error;
  }
}
