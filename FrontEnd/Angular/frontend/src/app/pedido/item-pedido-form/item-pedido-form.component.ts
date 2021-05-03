import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PedidoService } from '../pedido.service';

@Component({
  selector: 'app-item-pedido-form',
  templateUrl: './item-pedido-form.component.html',
  styleUrls: ['./item-pedido-form.component.scss']
})
export class ItemPedidoFormComponent implements OnInit {

  public meuForm : FormGroup;
  public isEdicao = false;
  public id_item_pedido = 0;

  constructor(private pedidoService: PedidoService, private formBuilder :FormBuilder, private activatedRoute: ActivatedRoute, private router : Router) { }

  ngOnInit(): void {
    this.meuForm = this.formBuilder.group(
      {
        quantidade : [null, [Validators.required, Validators.maxLength(6)]]
      }
    );
  }


  public onSubmit() {      
    if(this.isEdicao){
      //Edição
      this.pedidoService.update( this.id_item_pedido, this.meuForm.value )
        .subscribe(
          (data)=>{            
            this.router.navigate(['/pedidos']);
          }
        );
    }
    else {
      //criação
      this.pedidoService.save( this.meuForm.value ).subscribe(
        (data) => {         
          this.router.navigate(['/pedidos']);
        }
      );
    }

    
  }


}
