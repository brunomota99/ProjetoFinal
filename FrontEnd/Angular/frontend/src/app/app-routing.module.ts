import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: 'usuarios', loadChildren: () => import('./usuario/usuario.module').then(m =>m.UsuarioModule) },
  { path: 'produtos', loadChildren: () => import('./produto/produto.module').then( m => m.ProdutoModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
