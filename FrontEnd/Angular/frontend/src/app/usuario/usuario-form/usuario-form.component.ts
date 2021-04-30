import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
  styleUrls: ['./usuario-form.component.scss']
})

export class UsuarioFormComponent implements OnInit {

  public usuarioForm: FormGroup

  public isEdicao: boolean = false

  public id = 0

  constructor(private usuarioService: UsuarioService,
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private router: Router
    ) { }

    ngOnInit(): void {
      this.usuarioForm = this.formBuilder.group(
        {
          nomeUsuario: [null, [Validators.required]],
          cpfUsuario: [null, [Validators.required]],
          emailUsuario: [null, [Validators.required]],
          telefoneUsuario: [null, [Validators.required]],
          senhaUsuario: [null, [Validators.required]]
        }
      )
      this.activatedRoute.params
        .subscribe(
          (data) => {
            if (data.id) {
              this.isEdicao = true
              this.id = data.id
              this.usuarioService.getOne(this.id)
                .subscribe(
                  (usuario) => {
                    console.log(usuario)
                    this.usuarioForm.patchValue(usuario)
                  }
                )
            }
          }
        )
    }

  public onSubmit() {
    if (this.isEdicao) {
      this.usuarioService.update(this.id, this.usuarioForm.value)
        .subscribe(
          (data) => {
            console.log(data)
            this.router.navigate(['/usuarios'])
          }
        )
    }
    else {
      this.usuarioService.save(this.usuarioForm.value)
        .subscribe(
          (data) => {
            console.log(data)
            this.router.navigate(['/usuarios'])
          }
        )
    }
  }

  public isValid(campo): boolean {
    return (!this.usuarioForm.get(campo).valid && this.usuarioForm.get(campo).touched)
  }

}
