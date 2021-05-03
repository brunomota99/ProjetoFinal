import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PedidoRoutingModule } from './pedido-routing.module';
import { PedidoFormComponent } from './pedido-form/pedido-form.component';
import { ItempedidoListComponent } from './itempedido-list/itempedido-list.component';
import { SharedModule } from '../shared/shared.module';



@NgModule({
  declarations: [
    PedidoFormComponent,
    ItempedidoListComponent
  ],
  imports: [
    CommonModule,
    PedidoRoutingModule,
    SharedModule
  ]
})
export class PedidoModule { }
