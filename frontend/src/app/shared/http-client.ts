import { Injectable } from '@angular/core';
import { Http, Headers} from '@angular/http';
import { AuthService } from '../login/auth.service';

@Injectable()
export class HttpClient {
  baseUrl = "api/";

  constructor(private http: Http, private authService: AuthService) {}

  createAuthorizationHeader(headers: Headers) {
    headers.append("Content-Type", "application/json");
    if(this.authService.loggedIn()){
      headers.append("X-Auth-Token", this.authService.getProfile()["token"]);
    }
  }

  get(url) {
    let headers = new Headers();
    this.createAuthorizationHeader(headers);
    return this.http.get(this.baseUrl + url, {
      headers: headers
    });
  }

  post(url, data) {
    let headers = new Headers();
    this.createAuthorizationHeader(headers);
    console.log("Posting to:" + url);
    return this.http.post(this.baseUrl + url, JSON.stringify(data), {
      headers: headers
    });
  }

  delete(url, id){
    let headers = new Headers();
    this.createAuthorizationHeader(headers);
    console.log("Deleting to:" + url);
    return this.http.delete(this.baseUrl + url + "/" + id , {
      headers: headers
    });
  }
}
