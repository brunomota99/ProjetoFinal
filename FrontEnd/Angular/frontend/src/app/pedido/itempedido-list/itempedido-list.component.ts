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

    this.getAll();
  }

  ngOnInit(): void {

  }
  private getAll(){
    this.pedidoService.getAll()
    .subscribe(
      (data) => {
        console.log(data);
        this.itempedidos = data;
      }
    );
  }

    onDeleteClick(itempedido_id) {
    this.pedidoService.delete(itempedido_id)
      .subscribe(
        (data) => {
          this.getAll();
        }
      );
  }



}
