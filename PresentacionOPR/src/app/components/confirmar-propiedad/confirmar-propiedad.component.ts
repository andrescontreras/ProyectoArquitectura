import { Component, OnInit, Input } from '@angular/core';
import { Propiedad } from 'src/app/SideCar/Propiedad';
import { TransaccionDTO } from 'src/app/SideCar/TransaccionDTO';
import { ProxyRentarPropiedadService } from 'src/app/services/proxy-rentar-propiedad.service';
import { ConfirmarDTO } from 'src/app/SideCar/ConfirmarDTO';

@Component({
  selector: 'app-confirmar-propiedad',
  templateUrl: './confirmar-propiedad.component.html',
  styleUrls: ['./confirmar-propiedad.component.css']
})
export class ConfirmarPropiedadComponent implements OnInit {

  @Input() propiedad: Propiedad;
  @Input() id: number;
  alert = false;
  messageCom: string;

  confirmacion: ConfirmarDTO;
  constructor(private service: ProxyRentarPropiedadService) { }

  ngOnInit() {
    this.confirmacion = new ConfirmarDTO();
    console.log("ENTRO");
    this.confirmacion.idPropiedad = this.propiedad.id;
  }

  confirmarRenta() {
   this.service.confirmarRenta(this.confirmacion).subscribe((response) => {
    this.alert = true;
    this.messageCom  = response;
     console.log(response);
   });
  }
}
