import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProdutoService } from '../produto.service';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.scss']
})
export class ProdutoFormComponent implements OnInit {
  
  /* Variaveis */
  //Editar
  public isEdicao : boolean = false;
  public idProduto : number = 0;

  //Forms
  public formProd : FormGroup;

  constructor(
    private service : ProdutoService, 
    private fb : FormBuilder,
    private activateRoute : ActivatedRoute,
    private router : Router) { }

  ngOnInit(): void {
    this.formProd = this.fb.group({
      nomeProd: [null, [Validators.required]],
      precoUnitProd: [null, [Validators.required]],
      qtdeEstoqueProd: [null, [Validators.required]]
    });

    this.activateRoute.params
      .subscribe(
        (data) => {
          if(data.id){
            this.isEdicao = true;
            this.idProduto = data.id;

            this.getOne(data.id);
          }
        }
      );
  }

  // GetOne
  public getOne(id){
    this.service.getOne(id)
      .subscribe(
        (data) => {
          this.formProd.patchValue(data);
        }
      );
  }

  // Salvar Produto
  public onSubmit(){
    if(this.isEdicao){
      this.service.update(this.idProduto, this.formProd.value)
        .subscribe(
          (data) => {
            //this.router.navigate(['/produto']);
          }
        );
    }else{
      this.service.save(this.formProd.value)
        .subscribe(
          (data) => {
            //this.router.navigate(['/produto']);
          }
        );
    }
  }

  // Validação field-error
  public isValid(fieldName) : boolean{
    return (!this.formProd.get(fieldName).valid && this.formProd.get(fieldName).touched);
  }
}
