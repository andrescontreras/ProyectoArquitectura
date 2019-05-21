import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarPropiedadComponent } from './buscar-propiedad.component';

describe('BuscarPropiedadComponent', () => {
  let component: BuscarPropiedadComponent;
  let fixture: ComponentFixture<BuscarPropiedadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuscarPropiedadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuscarPropiedadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
