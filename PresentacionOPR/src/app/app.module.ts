import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BuscarPropiedadComponent } from './components/buscar-propiedad/buscar-propiedad.component';
import { DetallePropiedadComponent } from './components/detalle-propiedad/detalle-propiedad.component';
import { RentarPropiedadComponent } from './components/rentar-propiedad/rentar-propiedad.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavComponent } from './components/nav/nav.component';
import { AgregarPropiedadComponent } from './components/agregar-propiedad/agregar-propiedad.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    BuscarPropiedadComponent,
    DetallePropiedadComponent,
    RentarPropiedadComponent,
    FooterComponent,
    NavComponent,
    AgregarPropiedadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
