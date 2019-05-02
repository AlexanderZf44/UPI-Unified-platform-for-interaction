import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AppComponent} from "../app.component";
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) {
  }

  public logIn(username: String, password: String) {

    const base64Credential = btoa(username + ':' + password);

    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + base64Credential
    });

    const httpOptions = {
      headers: headers
    };

    return this.http.post(AppComponent.API_URL + "/user/login", httpOptions)
      .pipe(
        tap(
          data => localStorage.setItem('currentUser', data.toString())
        )
      )
  }
}
