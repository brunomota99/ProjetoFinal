import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
<<<<<<< HEAD
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { FieldErrorComponent } from './field-error/field-error.component';


=======
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';
>>>>>>> 0e90ccec8f8a574a7926f8e5f7e381deb8807c5d

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
    NgxPaginationModule
  ],
  exports: [
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ],
<<<<<<< HEAD
  exports : [
    NavbarComponent,
    FooterComponent,
    FieldErrorComponent
  ]
=======
>>>>>>> 0e90ccec8f8a574a7926f8e5f7e381deb8807c5d
})

export class SharedModule { }
