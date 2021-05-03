import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PedidoRoutingModule } from './pedido-routing.module';
import { PedidoListComponent } from './pedido-list/pedido-list.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { ItemPedidoFormComponent } from './item-pedido-form/item-pedido-form.component';
import { FormGroup } from '@angular/forms';
import { PedidoFormComponent } from './pedido-form/pedido-form.component';
import { ItempedidoListComponent } from './itempedido-list/itempedido-list.component';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    ItemPedidoFormComponent,
    PedidoFormComponent,
    ItempedidoListComponent
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
