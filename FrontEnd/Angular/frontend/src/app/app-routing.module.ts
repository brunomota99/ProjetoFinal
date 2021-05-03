import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PedidoListComponent } from './pedido/pedido-list/pedido-list.component';

const routes: Routes = [
  {path: 'pedidos', loadChildren: () => import ('./pedido/pedido.module').then(m=>m.PedidoModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
