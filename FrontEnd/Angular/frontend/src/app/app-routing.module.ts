import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioModule } from './usuario/usuario.module';

const routes: Routes = [
  { path: 'usuarios', loadChildren: () => import('./usuario/usuario.module').then(m =>m.UsuarioModule) },
  { path: 'produtos', loadChildren: () => import('./produto/produto.module').then(p =>p.ProdutoModule)}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
