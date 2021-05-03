import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProdutoService } from '../produto.service';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.scss']
})
export class ProdutoComponent implements OnInit {

  public produtoId : any;
  public produtos : any = [];
  constructor(private produtoService : ProdutoService, private route : Router) { }

  ngOnInit(): void {
  }

  public getById(id)
  {
    this.produtoService.getById(id)
    .subscribe((data) =>
    {
      this.produtoId = data
      // this.route.navigate('[/produtosdetalhes]')
    })
  }

  public getAll()
  {
    this.produtoService.getAll().subscribe((data) => 
    {
      this.produtos = data;
    })
  }

}
