import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SharedModule } from './shared/shared.module';
import { UsuarioModule } from './usuario/usuario.module';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptorService } from './shared/interceptos/auth-interceptor.service';
import { HttpConfigInterceptorService } from './shared/interceptos/http-config-interceptor.service';
import { registerLocaleData } from '@angular/common';

registerLocaleData(localePt, 'pt-BR');
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    UsuarioModule,
    NgbModule
  ],
  providers: [{
    provide : HTTP_INTERCEPTORS,
    useClass : AuthInterceptorService,
    multi : true
  },
  {
    provide : HTTP_INTERCEPTORS,
    useClass : HttpConfigInterceptorService,
    multi : true
  },
  { provide: LOCALE_ID, useValue: 'pt-BR' }
],
  bootstrap: [AppComponent]
})
export class AppModule { }
function localePt(localePt: any, arg1: string) {
  throw new Error('Function not implemented.');
}

