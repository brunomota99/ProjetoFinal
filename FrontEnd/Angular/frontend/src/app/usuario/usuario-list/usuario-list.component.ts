import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-usuario-list',
  templateUrl: './usuario-list.component.html',
  styleUrls: ['./usuario-list.component.scss']
})
export class UsuarioListComponent implements OnInit {

  public usuarios : any = [];

  constructor(private usuarioService : UsuarioService) { 
        
      this.usuarioService.getAll()
      .subscribe(
        (data) => {
          console.log(data)
          this.usuarios = data;
        }
      );
  }

  
 

  ngOnInit(): void {
  }

}
