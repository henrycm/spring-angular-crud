import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '../shared/http-client';
import { Producto } from './Producto';

@Injectable()
export class ProductosService {
  url: string = "productos";
  producto: Producto = new Producto();

  constructor(private http: HttpClient) {}

  save(producto: Producto){
     return this.http.post(this.url, producto);
  }

  remove(id: number){
    return this.http.delete(this.url, id);
  }

  getProducto(){
    return this.producto;
  }

  setProducto(producto: Producto){
    this.producto = producto;
  }

}
