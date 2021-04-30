import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoFormComponent } from './produto-form/produto-form.component';

const routes: Routes = [
  { path: '', component : ProdutoListComponent },
  { path: 'produto-form', component : ProdutoFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutoRoutingModule { }