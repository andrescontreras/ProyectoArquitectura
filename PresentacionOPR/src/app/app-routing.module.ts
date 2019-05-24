import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BuscarPropiedadComponent } from './components/buscar-propiedad/buscar-propiedad.component';
import { DetallePropiedadComponent } from './components/detalle-propiedad/detalle-propiedad.component';
import { RentarPropiedadComponent } from './components/rentar-propiedad/rentar-propiedad.component';
import { AgregarPropiedadComponent } from './components/agregar-propiedad/agregar-propiedad.component';

const routes: Routes = [
  {path: 'buscar', component: BuscarPropiedadComponent},
  {path: 'agregar', component: AgregarPropiedadComponent},
  {path: 'detalle/:id', component: DetallePropiedadComponent},
  {path: 'rentar/:id', component: RentarPropiedadComponent},

  {path: '', component: BuscarPropiedadComponent, pathMatch: 'full'},
  {path: '**', redirectTo: '/', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
