import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoListComponent } from './produto/produto-list/produto-list.component';

const routes: Routes = [
  { path: 'produtos', loadChildren: () => import('./produto/produto.module').then( m => m.ProdutoModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
