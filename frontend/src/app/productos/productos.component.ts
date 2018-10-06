import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from './Producto';
import { ProductosService } from './productos.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html'
})
export class ProductosComponent implements OnInit {
    productos = [];
    url = "productos";

    constructor(private router: Router, private productosService: ProductosService) {}

    ngOnInit() {}

    onPagination(message:any){
      this.productos = message;
    }

    add(){
      this.detail(new Producto());
    }

    remove(producto: Producto){
      this.productosService.remove(producto.id).subscribe(d=> {
          this.productos = this.productos.filter(p => p.id !== producto.id);
      });
    }

    detail(producto: Producto){
      this.productosService.setProducto(producto);
      this.router.navigate(["/productosForm"]);
    }
  }

  @Component({
    templateUrl: './producto.form.html'
  })
  export class ProductosForm implements OnInit {
    producto: Producto;
    constructor(private router: Router, private productosService: ProductosService) {
      this.producto = productosService.getProducto();
    }

    ngOnInit() {}

    onSubmit(){
      console.log(this.producto);
      this.productosService.save(this.producto).subscribe(d=> {
          this.router.navigate(["/productos"]);
      });
    }

  }
