import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  uri : string = `${environment.API_URI}/pedidos`;

  constructor(private httpService: HttpClient) { }

  // public getPagination(pagina : any, registros = 2, nomePedidoContains : string = "nenhumPedidoSelecionado"){  
  //   return this.httpService.get("http://localhost:8081/pedidos/paginacao/?pagina=" 
  //     + pagina + "&registros=" 
  //     + registros + "&procurar="
  //     + nomePedidoContains);    
  // }

  public delete(pedidoId : number){       
    return this.httpService.delete(`${this.uri}/${pedidoId}`);
  }

  public getPagination(pagina : any, registros = 2){   
    return this.httpService.get("http://localhost:8081/pedidos/paginacao/?pagina=" 
      + pagina + "&registros=" + registros);    
  }
}
