import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Propiedad } from '../SideCar/Propiedad';

@Injectable({
  providedIn: 'root'
})
export class RestBuscarPropiedadService {

  baseUrl = environment.baseUrl;
  url = this.baseUrl + '/propieda';
  constructor(private http: HttpClient) {
  }

  getAllData(): Observable<Propiedad[]>{

    return this.http.get<Propiedad[]>(this.url, {
      withCredentials: true
    });
  }

  getClienteby(id: number): Observable<Propiedad>{
    return this.http.get<Propiedad>(this.url , {
      withCredentials: true
    });
  }

  getClientebyNombre(nombre: string): Observable<Propiedad>{
    return this.http.get<Propiedad>(this.url + '/n/' + nombre  , {
      withCredentials: true
    });
  }

  getClientebyIdentificacion(id: number): Observable<Propiedad>{
    return this.http.get<Propiedad>(this.url + '/i/' + id  , {
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
