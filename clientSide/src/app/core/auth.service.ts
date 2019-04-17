import {Injectable} from '@angular/core'
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";

//todo change this service with new auth system
@Injectable()
export class AuthService {

  constructor(private http: HttpClient) {
  }

  attemptAuth(username: string, password: string): Observable{
    const credentials = {username: username, password:password};
    return this.http.post('http://localhost:8080/auth/generate-token', credentials);
  };

}
