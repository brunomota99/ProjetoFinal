import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoDetelheComponent } from './produto-detelhe/produto-detelhe.component';
import { ProdutoComponent } from './produto/produto.component';

const routes: Routes = [
    { path: '', component : ProdutoComponent},
    { path: 'produto-detalhe/:id', component : ProdutoComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutoRoutingModule { }
