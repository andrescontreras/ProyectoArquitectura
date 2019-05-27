import { Component, OnInit } from '@angular/core';
import { Propiedad } from 'src/app/SideCar/Propiedad';
import { RestBuscarPropiedadService } from 'src/app/services/proxy-buscar-propiedad.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detalle-propiedad',
  templateUrl: './detalle-propiedad.component.html',
  styleUrls: ['./detalle-propiedad.component.css']
})
export class DetallePropiedadComponent implements OnInit {

  id = 0;
  propiedad : Propiedad;
  
  constructor(private service: RestBuscarPropiedadService,private ruta: ActivatedRoute) { }

  async ngOnInit() {
    this.ruta.params.subscribe(params => {
      this.id = params['id'];
      
     
    } );
     await this.getPropiedad();
  }
  async getPropiedad(){
    this.propiedad = new Propiedad();
    // console.log("ENTRO get datos del detalle del producto");
    await this.service.getPropiedadPorId(this.id).subscribe(p => this.propiedad = p);
  }
  cambiarProducto(){
    // console.log("ENTRO get datos del detalle del producto");
    // this.service.actualizarProducto(this.producto).subscribe(p => this.producto = p);
  }

}
