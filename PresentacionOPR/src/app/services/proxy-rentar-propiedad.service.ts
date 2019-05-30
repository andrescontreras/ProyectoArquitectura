import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Propiedad } from '../SideCar/Propiedad';
import { Renta } from '../SideCar/Renta';
import { AprobacionDTO } from '../SideCar/AprobacionDTO';
import { TransaccionDTO } from '../SideCar/TransaccionDTO';

@Injectable({
  providedIn: 'root'
})
export class ProxyRentarPropiedadService {

  baseUrl = environment.baseUrl + 'renta';
  // url = this.baseUrl + '/propieda';
  url = this.baseUrl;
  constructor(private http: HttpClient) {
  }

  crearRenta(renta: TransaccionDTO){
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.http.post<AprobacionDTO>(this.url,renta, {
      headers: headers,
      withCredentials: true
    });
  }
}
