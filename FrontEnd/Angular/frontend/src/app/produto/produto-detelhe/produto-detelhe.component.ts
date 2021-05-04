import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProdutoService } from '../produto.service';

@Component({
  selector: 'app-produto-detelhe',
  templateUrl: './produto-detelhe.component.html',
  styleUrls: ['./produto-detelhe.component.scss']
})
export class ProdutoDetelheComponent implements OnInit {

  public nomeProd : string;
  public precoProd : number;
  public enderecos : any = [];


  constructor(private service : ProdutoService, private activatedRoute : ActivatedRoute) { }

  

  ngOnInit(): void {
  

    this.activatedRoute.params
    .subscribe(
      (data)=> {
        if(data.id){

          this.service.getById(data.id).subscribe(
            (produto : any) => {
              this.nomeProd = produto.nomeProd;
              this.precoProd = produto.precoUnitProd;
            }
          )

        }
      }
    )
  }


}
