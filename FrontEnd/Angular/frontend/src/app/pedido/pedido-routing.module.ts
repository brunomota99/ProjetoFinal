import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PedidoFormComponent } from './pedido-form/pedido-form.component';

const routes: Routes = [
  {path: 'pedido-form', component: PedidoFormComponent},
  {path: 'pedido-form/:id', component: PedidoFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PedidoRoutingModule { }
