import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItemPedidoFormComponent } from './item-pedido-form/item-pedido-form.component';
import { ItempedidoListComponent } from './itempedido-list/itempedido-list.component';
import { PedidoFormComponent } from './pedido-form/pedido-form.component';

const routes: Routes = [
  {path: 'pedido-form', component: PedidoFormComponent},
  {path: 'pedido-form/:id', component: PedidoFormComponent},
  { path: 'pedidoitens', component : ItempedidoListComponent },
  { path : 'item-pedido-form', component : ItemPedidoFormComponent },
  { path : 'item-pedido-form/:id', component : ItemPedidoFormComponent }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PedidoRoutingModule { }
