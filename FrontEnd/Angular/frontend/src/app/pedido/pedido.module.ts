import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PedidoRoutingModule } from './pedido-routing.module';
import { PedidoListComponent } from './pedido-list/pedido-list.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [
    PedidoListComponent
  ],
  imports: [
    CommonModule,
    PedidoRoutingModule,
    NgxPaginationModule,

    SharedModule
  ]
})
export class PedidoModule { }
