import {Injectable} from '@angular/core'
import {HttpClient} from "@angular/common/http";

//todo change this service with new auth system
@Injectable()
export class AuthService {

  constructor(private http: HttpClient) {
  }
}
