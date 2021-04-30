import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PedidoRoutingModule } from './pedido-routing.module';
import { ItemPedidoFormComponent } from './item-pedido-form/item-pedido-form.component';
import { SharedModule } from '../shared/shared.module';
import { FormGroup } from '@angular/forms';


@NgModule({
  declarations: [
    ItemPedidoFormComponent,
  ],
  imports: [
    CommonModule,
    PedidoRoutingModule,
    SharedModule
  ],
  exports : [
    ItemPedidoFormComponent
  ]
})
export class PedidoModule { }
