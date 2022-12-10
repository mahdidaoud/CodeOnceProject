import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) { }
  private host: String = "http://localhost:8080";
  public getProduct() {
    return this.httpClient.get(this.host + "/Product")

  }
  public addProduct(data: any) {
    return this.httpClient.post(this.host + "/AddProduct", data)
  }
  public getProdByCat(data: any) {
    return this.httpClient.post(this.host + "/ProdDispo", data)

  }
  public deleteproduct(data: any) {
    console.log(this.host + "/DeleteProd/" + data.id);
    return this.httpClient.delete(this.host + "/DeleteProd/" + data.id)

  }
}
