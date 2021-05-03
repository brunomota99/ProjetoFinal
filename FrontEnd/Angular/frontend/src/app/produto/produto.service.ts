import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private httpCliente : HttpClient) { }

  public getById (id)
  {
      return this.httpCliente.get(`${environment.API_URI}/produto/${id}`);
  }

  public getAll()
  {
    return this.httpCliente.get(`${environment.API_URI}/produto`)
  }
}
