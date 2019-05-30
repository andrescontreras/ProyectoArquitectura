import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Propiedad } from '../SideCar/Propiedad';
import { Renta } from '../SideCar/Renta';

@Injectable({
  providedIn: 'root'
})
export class ProxyRentarPropiedadService {

  baseUrl = environment.baseUrl + 'renta';
  // url = this.baseUrl + '/propieda';
  url = this.baseUrl;
  constructor(private http: HttpClient) {
  }

  crearRenta(renta: Renta){
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.http.post<Propiedad>(this.url,renta, {
      headers: headers,
      withCredentials: true
    });
  }
}
