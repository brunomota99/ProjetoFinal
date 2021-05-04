import { Component, OnInit } from '@angular/core';
import { take } from 'rxjs/operators';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-usuario-list',
  templateUrl: './usuario-list.component.html',
  styleUrls: ['./usuario-list.component.scss']
})
export class UsuarioListComponent implements OnInit {
  public usuarios : any = [];

  public pageSize : number = 2;
    public p : number = 1 ;
    public paginaRest : number = this.p - 1;
    public total : number = 0 ;

  constructor(private usuarioService : UsuarioService) { 
        this.getPagination();
  }

  ngOnInit(): void {
  }

  private getPagination(){
  this.usuarioService.getPagination(this.paginaRest, this.pageSize)
  .pipe(take(1))
  .subscribe(
    (data : any) => {
      console.log(data)
      this.usuarios = data.content;
      this.total = data.totalElements;
    }
  );
  }

  public pageChanged(evento){
    console.log(evento);
    this.p = evento;
    this.paginaRest =  this.p - 1;
    this.getPagination ();
  }
  
  onDelete (idUsuario){
    this.usuarioService.delete(idUsuario)
    .subscribe(
      (data) => {
      alert ("dado apagado")
      this.getPagination();
      }
    )
  }
 
}
