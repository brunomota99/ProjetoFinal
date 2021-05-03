import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItempedidoListComponent } from './itempedido-list.component';

describe('ItempedidoListComponent', () => {
  let component: ItempedidoListComponent;
  let fixture: ComponentFixture<ItempedidoListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItempedidoListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ItempedidoListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
