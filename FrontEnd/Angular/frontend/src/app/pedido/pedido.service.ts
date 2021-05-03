import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})



export class PedidoService {


  uri : string = `${environment.API_URI}/pedidos`;

  constructor(private httpService: HttpClient) { }

  public getOne(idPedido : any){
    return this.httpService.get(`${this.uri}/${idPedido}`);
  }

  public save (newPedido : any){
    return this.httpService.post(`${this.uri}`, newPedido)
  }

  public update (idPedido : any, newPedido  :any){
    return this.httpService.patch(`${this.uri}/${idPedido}`, newPedido);
  }

}
