import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class AuthService {

  constructor(private http: Http) {}

  private baseUrl = "/"
  private url = this.baseUrl + "auth";
  private profile = {};

  login(form){
    let bodyString = JSON.stringify(form);
    console.log("Form:" + bodyString);
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });

    let result = this.http.post(this.url, bodyString, options)
     .map((res:Response) => res.json());

     result.subscribe(data => {
        this.profile = data;
        console.log(this.profile);
     });

     return result;
  }

  loggedIn() {
    return this.profile.hasOwnProperty("token");
  }

  getProfile(){
    return this.profile;
  }
}
