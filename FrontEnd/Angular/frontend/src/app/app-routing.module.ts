import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioListComponent } from './usuario/usuario-list/usuario-list.component';
import { UsuarioModule } from './usuario/usuario.module';

const routes: Routes = [
  { path: 'usuario', loadChildren: () => import('./usuario/usuario.module').then(m =>m.UsuarioModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
