import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PedidoRoutingModule } from './pedido-routing.module';
import { NgxPaginationModule } from 'ngx-pagination';
import { ItemPedidoFormComponent } from './item-pedido-form/item-pedido-form.component';
import { PedidoFormComponent } from './pedido-form/pedido-form.component';
import { ItempedidoListComponent } from './itempedido-list/itempedido-list.component';
import { SharedModule } from '../shared/shared.module';
import { PedidoListComponent } from './pedido-list/pedido-list.component';

@NgModule({
  declarations: [
    ItemPedidoFormComponent,
    PedidoFormComponent,
    ItempedidoListComponent,
    PedidoListComponent
  ],
  imports: [
    CommonModule,
    PedidoRoutingModule,
    NgxPaginationModule,
    SharedModule
  ],
  exports : [
    ItemPedidoFormComponent
  ]
})
export class PedidoModule { }
