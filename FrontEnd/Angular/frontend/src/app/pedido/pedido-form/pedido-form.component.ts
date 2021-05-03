import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PedidoService } from '../pedido.service';

@Component({
  selector: 'app-pedido-form',
  templateUrl: './pedido-form.component.html',
  styleUrls: ['./pedido-form.component.scss']
})
export class PedidoFormComponent implements OnInit {

  public isEdit = false;
  public myForm : FormGroup;
  public pedido: any;
  public idPedido = 0;
  


  constructor(private pedidoService : PedidoService, private formBuilder : FormBuilder, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(
      (data)=>{
        console.log(data);
        if(data.id){
          this.isEdit =true;
          this.idPedido = data.id;

          this.pedidoService.getOne(data.id).subscribe(
            (pedido: any) =>{
              this.myForm.patchValue(pedido);
            }
          )
        }
      }
    );

      this.myForm=this.formBuilder.group(
        {
          totalPedido: [null, [Validators.required]]
        }
      );

  }

  // public isValid(fieldName : any) : boolean{
  //   return (!this.myForm.get(fieldName).valid && this.myForm.get(fieldName).touched)
  // }

  public onSubmit(){
    console.log(this.myForm)

    if (this.isEdit) {
      this.pedidoService.update(this.idPedido, this.myForm.value)
      .subscribe(
        (data) => {
          console.log(data)
          this.router.navigate(['/pedidos']);
        }
      );
    } else {
      this.pedidoService.save(this.myForm.value)
      .subscribe(
        (data) =>{
          console.log(data);
          this.router.navigate(['/pedidos']);

        }
      )
      
    }
  }

}
