import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RentarPropiedadComponent } from './rentar-propiedad.component';

describe('RentarPropiedadComponent', () => {
  let component: RentarPropiedadComponent;
  let fixture: ComponentFixture<RentarPropiedadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RentarPropiedadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RentarPropiedadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
