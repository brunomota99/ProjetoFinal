import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ItempedidoListComponent } from './itempedido-list/itempedido-list.component';

const routes: Routes = [
  { path: '', component : ItempedidoListComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PedidoRoutingModule { }
