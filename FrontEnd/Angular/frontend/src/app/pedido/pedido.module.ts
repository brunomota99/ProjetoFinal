import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PedidoRoutingModule } from './pedido-routing.module';
import { PedidoFormComponent } from './pedido-form/pedido-form.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    PedidoFormComponent
  ],
  imports: [
    CommonModule,
    PedidoRoutingModule,
    SharedModule
  ]
})
export class PedidoModule { }
