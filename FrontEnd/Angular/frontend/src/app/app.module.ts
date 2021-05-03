import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SharedModule } from './shared/shared.module';
import { PedidoFormComponent } from './pedido/pedido-form/pedido-form.component';
import { PedidoModule } from './pedido/pedido.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    SharedModule,
    //PedidoModule -tira dps do lazy
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
