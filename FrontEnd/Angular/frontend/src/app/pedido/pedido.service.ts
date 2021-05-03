import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {
    //item Pedido List
  uri : string = `${environment.API_URI}/item-pedidos`;

  constructor(private httpService: HttpClient) {   }

  //GetAll do item pedido list
  public getAll(){
    return this.httpService.get(this.uri);
  }
  //Delete do item pedido list
  public delete(itempedido_id){
    return this.httpService.delete(`${this.uri}/${itempedido_id}`);
  }

}