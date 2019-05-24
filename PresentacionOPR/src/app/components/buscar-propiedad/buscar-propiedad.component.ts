import { Component, OnInit } from '@angular/core';
import { Propiedad } from 'src/app/SideCar/Propiedad';
import { RestBuscarPropiedadService } from 'src/app/services/proxy-buscar-propiedad.service';

@Component({
  selector: 'app-buscar-propiedad',
  templateUrl: './buscar-propiedad.component.html',
  styleUrls: ['./buscar-propiedad.component.css']
})
export class BuscarPropiedadComponent implements OnInit {

  propiedades: Propiedad[] = [];
  constructor(private service: RestBuscarPropiedadService) { }

  ngOnInit() {
  //  this.llenarDatosPrueba();
   this.getDatos();
  }

  getDatos(){
    console.log("ENTRO get datos");
    this.service.getAllData().subscribe(p => this.propiedades = p);
  }

}
