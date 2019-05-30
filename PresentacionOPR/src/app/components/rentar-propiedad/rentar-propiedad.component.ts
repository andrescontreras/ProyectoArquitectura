import { Component, OnInit, Input } from '@angular/core';
import { Propiedad } from 'src/app/SideCar/Propiedad';
import { TransaccionDTO } from 'src/app/SideCar/TransaccionDTO';
import { ProxyRentarPropiedadService } from 'src/app/services/proxy-rentar-propiedad.service';

@Component({
  selector: 'app-rentar-propiedad',
  templateUrl: './rentar-propiedad.component.html',
  styleUrls: ['./rentar-propiedad.component.css']
})
export class RentarPropiedadComponent implements OnInit {

  @Input() propiedad: Propiedad;
  @Input() id: number;


  transaccion: TransaccionDTO;
  constructor(private service: ProxyRentarPropiedadService) { }

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
    console.log(this.transaccion);
    this.service.crearRenta(this.transaccion).subscribe((response) => {
      console.log(response);
    });
  }
}
