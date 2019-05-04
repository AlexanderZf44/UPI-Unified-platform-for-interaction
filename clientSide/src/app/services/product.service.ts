import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AppComponent} from "../app.component";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  constructor(private http: HttpClient) {
  }

  public getAllProducts() {
    return this.http.get(AppComponent.API_URL + "/product/all");
  }

  public getAllProductsByIds(productIds: number[]) {
    return this.http.get(AppComponent.API_URL + "/product/" + productIds.join(','));
  }
}
