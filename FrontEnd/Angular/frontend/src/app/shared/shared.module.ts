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
import { CepPipe } from './pipes/cep.pipe';
import { CpfPipe } from './pipes/cpf.pipe';
import { TelephonePipe } from './pipes/telephone.pipe';




@NgModule({
  declarations: [
    NavbarComponent,
    FooterComponent,
    FieldErrorComponent,
    CepPipe, 
    CpfPipe,
    TelephonePipe
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
    ToastrModule, 
    CepPipe,
    CpfPipe,
    TelephonePipe
  ]
})

export class SharedModule { }
