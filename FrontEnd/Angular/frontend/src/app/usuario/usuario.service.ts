import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  url : string = `${environment.API_URI}`;


  constructor(private httpService : HttpClient) { }

 
  public getAll(){
    return this.httpService.get(`${this.url}/usuarios`);
  }
}
