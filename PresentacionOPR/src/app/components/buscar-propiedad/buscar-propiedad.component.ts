import { Component, OnInit } from '@angular/core';
import { Propiedad } from 'src/app/SideCar/Propiedad';
import { ProxyBuscarPropiedadService } from 'src/app/services/proxy-buscar-propiedad.service';

@Component({
  selector: 'app-buscar-propiedad',
  templateUrl: './buscar-propiedad.component.html',
  styleUrls: ['./buscar-propiedad.component.css']
})
export class BuscarPropiedadComponent implements OnInit {

  propiedades: Propiedad[] = [];
  busqueda = "";
  marked1 = true;
  marked2 = false;
  constructor(private service: ProxyBuscarPropiedadService) { }

  ngOnInit() {
  //  this.llenarDatosPrueba();
   this.getDatos();
  }

  getDatos(){
    console.log("ENTRO get datos");
    this.service.getAllData().subscribe(p => this.propiedades = p);
  }

  valor1()
  {
    this.marked1 = true;
    this.marked2 = !this.marked1;
    
  }
  valor2()
  {
    this.marked2 = true;
    this.marked1 = !this.marked2;
    
  }

  buscarPropiedad(){
    if(this.marked1){
      this.service.getPropiedadPorNombre(this.busqueda).subscribe(p => this.propiedades = p);
    }else{
      this.service.getPropiedadPorCedula(this.busqueda).subscribe(p => this.propiedades = p);
    }
  }

}
