import { Injectable } from '@angular/core';
import { Cliente } from './../class/cliente';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestClienteService {

  baseUrl = environment.baseUrl;
  url = this.baseUrl + '/cliente';
  constructor(private http: HttpClient) {
  }

  getAllData(): Observable<Cliente[]>{

    return this.http.get<Cliente[]>(this.url, {
      withCredentials: true
    });
  }

  getClienteby(id: number): Observable<Cliente>{
    return this.http.get<Cliente>(this.url , {
      withCredentials: true
    });
  }

  getClientebyNombre(nombre: string): Observable<Cliente>{
    return this.http.get<Cliente>(this.url + '/n/' + nombre  , {
      withCredentials: true
    });
  }

  getClientebyIdentificacion(id: number): Observable<Cliente>{
    return this.http.get<Cliente>(this.url + '/i/' + id  , {
      withCredentials: true
    });
  }

  crearCliente(cliente :Cliente){

    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    return this.http.post<Cliente>(this.url,cliente, {
      headers: headers,
      withCredentials: true
    });
  }
}
