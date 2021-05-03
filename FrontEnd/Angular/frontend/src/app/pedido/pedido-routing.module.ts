import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItempedidoListComponent } from './itempedido-list/itempedido-list.component';
import { PedidoFormComponent } from './pedido-form/pedido-form.component';

const routes: Routes = [
  {path: 'pedido-form', component: PedidoFormComponent},
  {path: 'pedido-form/:id', component: PedidoFormComponent},
  { path: 'pedidoitens', component : ItempedidoListComponent }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PedidoRoutingModule { }
