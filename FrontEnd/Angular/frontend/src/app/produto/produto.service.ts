import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  private uri = `${environment.API_URI}/produto`;

  constructor(private httpService : HttpClient) { }

  public getAll(){
    return this.httpService.get(this.uri);
  }

  public getOne(id){
    return this.httpService.get(`${this.uri}/${id}`);
  }

  public save(newProd){
    return this.httpService.post(this.uri,newProd);
  }

  public delete(id){
    return this.httpService.delete(`${this.uri}/${id}`);
  }

  public update(id, newProd){
    return this.httpService.patch(`${this.uri}/${id}`, newProd);
  }
}
