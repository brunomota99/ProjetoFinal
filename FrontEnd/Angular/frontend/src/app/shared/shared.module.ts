import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { FieldErrorComponent } from './field-error/field-error.component';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';
import { ToastrModule } from 'ngx-toastr';




@NgModule({
  declarations: [
    NavbarComponent,
    FooterComponent,
    FieldErrorComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule,
    ToastrModule.forRoot()
  ],
  exports: [
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    NavbarComponent,
    FooterComponent,
    FieldErrorComponent,
    ToastrModule
  ]
})

export class SharedModule { }
