import { Component, OnInit } from '@angular/core';
import { PedidoService } from '../pedido.service';
import { take } from 'rxjs/operators';

@Component({
  selector: 'app-pedido-list',
  templateUrl: './pedido-list.component.html',
  styleUrls: ['./pedido-list.component.scss']
})
export class PedidoListComponent implements OnInit {

  pedidos : any = [];

   // nomeMateriaContains : string;
 

  // Beginning of the variables to manage pagination  
  public pageSize : number = 3;

  public pageSizeUpdated : any = 3;

  public total : number = 0;

    // page variable used for NgxPagination
  public paginaNgx : number = 1 ;
  
    // page variable used for the backend application because pagination no Spring starts with '0'.
  public paginaRest : number = this.paginaNgx -1;

  // End of the variables to manage pagination

  constructor(private pedidoService : PedidoService) { }

  ngOnInit(): void {
    this.getPagination();
  }

  public getPagination(){
    this.pedidoService.getPagination(this.paginaRest, this.pageSize)
      .pipe( take(1) )
      .subscribe(
        (paginationData : any) => {
          console.log(paginationData)
          this.pedidos = paginationData.content;
          this.total = paginationData.totalElements;
        }
      );
  }


  public pageChanged(evento : any){
    this.paginaNgx = evento;
    this.paginaRest = this.paginaNgx - 1;
    this.getPagination();    
  }


  onClickApplyFilter(){
    this.pageSize = this.pageSizeUpdated;
    this.getPagination();
  }


  onDeletarPedido(pedidoId : number){
    console.log("id chegando" + pedidoId)
    this.pedidoService.delete(pedidoId)
    .pipe( take(1) )
      .subscribe(
        (data) => { 
          console.log("dentro do data");
          console.log(data);
          this.getPagination();          
        }
      );
  }





}
