import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../produto.service';

@Component({
  selector: 'app-produto-list',
  templateUrl: './produto-list.component.html',
  styleUrls: ['./produto-list.component.scss']
})
export class ProdutoListComponent implements OnInit {

  public produto : any = [];

  constructor(private service : ProdutoService) {
    this.getAll();
  }

  ngOnInit(): void {}

  public getAll() {
    return this.service.getAll()
      .subscribe(
        (data) => {
          console.log(data);
          this.produto = data;
        }
      );
  }

}
