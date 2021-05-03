import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})



export class PedidoService {
    //item Pedido List
  uriItemPedido : string = `${environment.API_URI}/item-pedidos`;

  uriPedido : string = `${environment.API_URI}/pedidos`;

  constructor(private httpService: HttpClient) { }

  public getOne(idPedido : any){
    return this.httpService.get(`${this.uriPedido}/${idPedido}`);
  }

  public save (newPedido : any){
    return this.httpService.post(`${this.uriPedido}`, newPedido)
  }

  public update (idPedido : any, newPedido  :any){
    return this.httpService.patch(`${this.uriPedido}/${idPedido}`, newPedido);
  }





  //GetAll do item pedido list
  public getAllItemPedido(){
    return this.httpService.get(this.uriItemPedido);
  }
  //Delete do item pedido list
  public deleteItemPedido (itempedido_id){
    return this.httpService.delete(`${this.uriItemPedido}/${itempedido_id}`);
  }

}

