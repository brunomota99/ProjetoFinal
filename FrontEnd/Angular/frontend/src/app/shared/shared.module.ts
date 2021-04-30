import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { FieldErrorComponent } from './field-error/field-error.component';



@NgModule({
  declarations: [
    NavbarComponent,
    FooterComponent,
    FieldErrorComponent
  ],
  imports: [
    CommonModule
  ],
  exports : [
    NavbarComponent,
    FooterComponent
  ]
})
export class SharedModule { }
