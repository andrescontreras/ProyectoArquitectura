import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Propiedad } from '../SideCar/Propiedad';

@Injectable({
  providedIn: 'root'
})
export class ProxyBuscarPropiedadService {

  baseUrl = environment.baseUrl + 'propiedad';
  // url = this.baseUrl + '/propieda';
  url = this.baseUrl;
  constructor(private http: HttpClient) {
  }

  getAllData(): Observable<Propiedad[]>{

    return this.http.get<Propiedad[]>(this.url, {
      withCredentials: true
    });
  }

  getPropiedadPorNombre(nombre:string){
    return this.http.get<Propiedad[]>(this.url + '/'+ 'nombre'+ '/' + nombre  , {
      withCredentials: true
    });
  }

  getPropiedadPorCedula(cedula:string){
    return this.http.get<Propiedad[]>(this.url + '/'+ 'cedula'+ '/' + cedula  , {
      withCredentials: true
    });
  }

  getPropiedadPorId(id: number){
    return this.http.get<Propiedad>(this.url + '/' + id  , {
      withCredentials: true
    });
  }

  crearCliente(cliente: Propiedad){
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.http.post<Propiedad>(this.url,cliente, {
      headers: headers,
      withCredentials: true
    });
  }
}
