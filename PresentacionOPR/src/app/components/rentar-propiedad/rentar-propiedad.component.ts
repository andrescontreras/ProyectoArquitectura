import { Component, OnInit, Input } from '@angular/core';
import { Propiedad } from 'src/app/SideCar/Propiedad';
import { TransaccionDTO } from 'src/app/SideCar/TransaccionDTO';
import { ProxyRentarPropiedadService } from 'src/app/services/proxy-rentar-propiedad.service';
import { formatDate, DatePipe } from '@angular/common';

@Component({
  selector: 'app-rentar-propiedad',
  templateUrl: './rentar-propiedad.component.html',
  styleUrls: ['./rentar-propiedad.component.css']
})
export class RentarPropiedadComponent implements OnInit {

  @Input() propiedad: Propiedad;
  @Input() id: number;
  alertCorrecto = false;
  alertError = false;
  messageCom: string;

  transaccion: TransaccionDTO;
  constructor(private service: ProxyRentarPropiedadService) { }

  ngOnInit() {
    this.transaccion = new TransaccionDTO();
    console.log("ENTRO");
    this.transaccion.descontar = this.propiedad.precio;
    this.transaccion.idPropiedad = this.propiedad.id;
  }

  confirmarRenta() {
    console.log(this.propiedad, this.id);
    this.transaccion.descontar = this.propiedad.precio;
    this.transaccion.idPropiedad = this.propiedad.id;
    console.log(this.transaccion);
    var datePipe = new DatePipe("en-US");
    this.service.crearRenta(this.transaccion).subscribe((response) => {
      console.log(response);
      switch (response.estado) {
        case 2:
          this.alertCorrecto = true;
          this.alertError = false;
          this.messageCom = "Pago realizado exitosamente\ Numero aprobación: " + response.fechaAprobacion + "\  " + "Fecha de aprobación" + response.fechaAprobacion;
          ;
          break;
        case 1:
          this.alertError = true;
          this.alertCorrecto = false;
          this.messageCom = "El usuarios no tiene fondos suficientes";
          break;
        case 0:
          this.alertError = true;
          this.alertCorrecto = false;
          this.messageCom = "El usuarios no existe en la base de datos";
          break;
      }
    });
  }
}
