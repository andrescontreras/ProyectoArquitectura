import { Component, OnInit, Input } from '@angular/core';
import { Propiedad } from 'src/app/SideCar/Propiedad';
import { TransaccionDTO } from 'src/app/SideCar/TransaccionDTO';

@Component({
  selector: 'app-rentar-propiedad',
  templateUrl: './rentar-propiedad.component.html',
  styleUrls: ['./rentar-propiedad.component.css']
})
export class RentarPropiedadComponent implements OnInit {

  @Input() propiedad: Propiedad;
  @Input() id: number;

  transaccion: TransaccionDTO;
  constructor() { }

  ngOnInit() {
    this.transaccion = new TransaccionDTO();
    console.log("ENTRO");
    this.transaccion.monto = this.propiedad.precio;
    this.transaccion.idPropiedad = this.propiedad.id;
    debugger;
  }

  confirmarRenta(){
    console.log(this.propiedad, this.id);
    this.transaccion.monto = this.propiedad.precio;
    this.transaccion.idPropiedad = this.propiedad.id;
  }
}
