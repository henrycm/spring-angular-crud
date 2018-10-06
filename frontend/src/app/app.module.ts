import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing } from './app.routes';

import { AppComponent } from './app.component';
import { ColoresComponent, ColoresForm } from './colores/colores.component';
import { ColoresService } from './colores/colores.service';
import { ProductosComponent, ProductosForm } from './productos/productos.component';
import { ProductosService } from './productos/productos.service';
import { LoginComponent } from './login/login.component';
import { AuthService } from './login/auth.service';
import { AuthGuard } from './login/auth-guard.service';
import { HttpClient } from './shared/http-client';
import { PagerComponent } from './shared/pager/pager.component';

@NgModule({
  declarations: [
    AppComponent,
    ColoresForm,
    ColoresComponent,
    ProductosForm,
    ProductosComponent,
    LoginComponent,
    PagerComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    routing
  ],
  providers: [AuthService, AuthGuard, HttpClient, ColoresService, ProductosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
