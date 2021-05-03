import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {
  uri : string = `${environment.API_URI}/item-pedidos`;

  constructor( private httpService: HttpClient) { }

  public save (newItemPedido : any){
    return this.httpService.post(`${this.uri}`, newItemPedido);
  }

  public update (idItemPedido : any, newItemPedido  :any){
    return this.httpService.patch(`${this.uri}/${idItemPedido}`, newItemPedido);
  }


}
