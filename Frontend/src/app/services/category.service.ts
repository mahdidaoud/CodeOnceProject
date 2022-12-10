import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient: HttpClient) { }
  private host: String = "http://localhost:8080";
  public getCategory() {
    return this.httpClient.get(this.host + "/Categories")

  }
  public addCategory(data: any) {
    return this.httpClient.post(this.host + "/AddCategory", data)
  }
  public DeleteCategory(data: any) {
    return this.httpClient.delete(this.host + "/DeleteCategory/" + data.id)
  }
}
