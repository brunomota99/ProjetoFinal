import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {
  uri : string = `${environment.API_URI}/pedidos`;

  constructor( ) { }
}
