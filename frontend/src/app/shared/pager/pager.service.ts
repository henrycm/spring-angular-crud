import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { HttpClient } from '../../shared/http-client';

@Injectable()
export class PagerService {

  constructor(private http: HttpClient) {}

  getPage(url, page){
    return this.http.get(url + "?size=2&page=" + page).map(res => res.json() || {});
  }
}
