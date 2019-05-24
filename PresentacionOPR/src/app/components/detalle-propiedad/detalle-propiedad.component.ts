import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-detalle-propiedad',
  templateUrl: './detalle-propiedad.component.html',
  styleUrls: ['./detalle-propiedad.component.css']
})
export class DetallePropiedadComponent implements OnInit {

  equipo: any[] = [];
  id: number;
  producto : any;
  constructor() { }

  ngOnInit() {
    this.producto = [{
      id: 1,
      cantidad: 1000,
      codigoSKU: 'abc',
      nombre: 'nombre1',
      precio: 200,
      undMed: 'Lb'
    }];
    console.log(this.producto);
    this.getDatos();
  }
  getDatos(){
    // console.log("ENTRO get datos del detalle del producto");
    // this.service.getProductoByID(this.id).subscribe(p => this.producto = p);
  }
  cambiarProducto(){
    // console.log("ENTRO get datos del detalle del producto");
    // this.service.actualizarProducto(this.producto).subscribe(p => this.producto = p);
  }

}
