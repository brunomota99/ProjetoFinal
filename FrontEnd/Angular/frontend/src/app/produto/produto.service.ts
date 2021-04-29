import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  private uri = `${environment.API_URI}/produto`;

  constructor(private http : HttpClient) { }

  public getAll() {
    return this.http.get(this.uri);
  }

  public getOne(id : number){
    return this.http.get(`${this.uri}/${id}`);
  }
}
