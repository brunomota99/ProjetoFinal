import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProdutoDetelheComponent } from './produto-detelhe/produto-detelhe.component';
import { ProdutoComponent } from './produto/produto.component';



@NgModule({
  declarations: [
    ProdutoDetelheComponent,
    ProdutoComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ProdutoModule { }
