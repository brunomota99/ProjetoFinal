import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItemPedidoFormComponent } from './item-pedido-form/item-pedido-form.component';

const routes: Routes = [
  { path : 'item-pedido-form', component : ItemPedidoFormComponent },
  { path : 'item-pedido-form/:id', component : ItemPedidoFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PedidoRoutingModule { }
