import { Component, OnInit } from '@angular/core';
import { PedidoService } from '../pedido.service';

@Component({
  selector: 'app-itempedido-list',
  templateUrl: './itempedido-list.component.html',
  styleUrls: ['./itempedido-list.component.scss']
})
export class ItempedidoListComponent implements OnInit {

  public itempedidos : any = [];  
  public pedidoDetalhe : any;

  constructor(private pedidoService :PedidoService) { 

    this.getAllItemPedido();
  }

  ngOnInit(): void {

  }
  private getAllItemPedido(){
    this.pedidoService.getAllItemPedido()
    .subscribe(
      (data) => {
        console.log(data);
        this.itempedidos = data;
      }
    );
  }

    onDeleteClick(itempedido_id) {
    this.pedidoService.deleteItemPedido(itempedido_id)
      .subscribe(
        (data) => {
          this.getAllItemPedido();
        }
      );
  }



}
