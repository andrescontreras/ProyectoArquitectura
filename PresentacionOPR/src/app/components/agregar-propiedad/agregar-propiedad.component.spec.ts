import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarPropiedadComponent } from './agregar-propiedad.component';

describe('AgregarPropiedadComponent', () => {
  let component: AgregarPropiedadComponent;
  let fixture: ComponentFixture<AgregarPropiedadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AgregarPropiedadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AgregarPropiedadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
