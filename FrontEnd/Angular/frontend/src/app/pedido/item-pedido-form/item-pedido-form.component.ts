import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { PedidoService } from '../pedido.service';

@Component({
  selector: 'app-item-pedido-form',
  templateUrl: './item-pedido-form.component.html',
  styleUrls: ['./item-pedido-form.component.scss']
})
export class ItemPedidoFormComponent implements OnInit {

  public meuForm : FormGroup;

  constructor(private pedidoService: PedidoService, private formBuilder :FormBuilder, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.meuForm = this.formBuilder.group(
      {
        quantidade : [null, [Validators.required, Validators.maxLength(6)]]
      }
    );
  }

  public onSubmit(){
    
  }

}
