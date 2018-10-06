import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { Color } from './Color';
import { ColoresService } from './colores.service';

@Component({
  selector: 'app-colores',
  templateUrl: './colores.component.html'
})
export class ColoresComponent implements OnInit {
  colores = [];
  url = "colores";

  constructor(private router: Router, private coloresService: ColoresService) {}

  ngOnInit() {}

  onPagination(message:any){
    this.colores = message;
  }

  add(){
    this.coloresService.setColor(new Color());
    this.router.navigate(["/coloresForm"]);
  }

  remove(color: Color){
    this.coloresService.remove(color.id).subscribe(d=> {
        this.colores = this.colores.filter(c => c.id !== color.id);
    });
  }

  detail(c: Color){
    this.coloresService.setColor(c);
    this.router.navigate(["/coloresForm"]);
  }
}

@Component({
  templateUrl: './colores.form.html'
})
export class ColoresForm implements OnInit {
  color: Color;
  constructor(private router: Router, private coloresService: ColoresService) {
    this.color = coloresService.getColor();
  }

  ngOnInit() {}

  onSubmit(){
    console.log(this.color);
    this.coloresService.save(this.color).subscribe(d=> {
        this.router.navigate(["/colores"]);
    });
  }

}
