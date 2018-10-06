import { Injectable } from '@angular/core';
import { Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '../shared/http-client';
import { Color } from './Color';

@Injectable()
export class ColoresService {
  url: string = "colores";
  color: Color = new Color();

  constructor(private http: HttpClient) {}

  save(color: Color){
     return this.http.post(this.url, color);
  }

  remove(id: number){
    return this.http.delete(this.url, id);
  }
  
  getColor(){
    return this.color;
  }

  setColor(color: Color){
    this.color = color;
  }

}
