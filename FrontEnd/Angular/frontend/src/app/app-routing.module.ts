import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsuarioModule } from './usuario/usuario.module';

const routes: Routes = [
  { path: 'usuarios', loadChildren: () => import('./usuario/usuario.module').then(m =>m.UsuarioModule) },
  { path: 'auth', loadChildren: ()=> import('./auth/auth.module').then (m => m.AuthModule)  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
