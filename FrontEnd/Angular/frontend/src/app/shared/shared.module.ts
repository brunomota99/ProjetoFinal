import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [],
  imports: [
    RouterModule,
    CommonModule       
  ],
  exports : [
    HttpClientModule,
    FormsModule      
  ]
})
export class SharedModule { }
