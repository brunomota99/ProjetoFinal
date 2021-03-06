import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  url: string = `${environment.API_URI}/usuarios`;


  constructor(private httpService: HttpClient) { }


  public getAll() {
    return this.httpService.get(`${this.url}`);
  }

  public save(newUsuario) {
    console.log(newUsuario)
    return this.httpService.post(`${this.url}`, newUsuario);
  }

  public update(id, updateUsuario) {
    return this.httpService.patch(`${this.url}/${id}`, updateUsuario);
  }

  public getOne(id) {
    return this.httpService.get(`${this.url}/${id}`);
  }
  public delete (id : any) {
    return this.httpService.delete(`${this.url}/${id}`);
  }

  public getPagination(pagina, registrosPorPagina = 2){
    return this.httpService.get(`${this.url}/paginacao?pagina=${pagina}&registros=${registrosPorPagina}`);
  }
}
