import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProdutoDetelheComponent } from './produto-detelhe/produto-detelhe.component';
import { ProdutoComponent } from './produto/produto.component';
import { SharedModule } from '../shared/shared.module';
import { ProdutoRoutingModule } from './produto-routing.module';



@NgModule({
  declarations: [
    ProdutoDetelheComponent,
    ProdutoComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    ProdutoRoutingModule
  ]
})
export class ProdutoModule { }
