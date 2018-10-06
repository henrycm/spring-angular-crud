import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule,CanActivateChild } from '@angular/router';
import { ColoresComponent, ColoresForm } from './colores/colores.component';
import { ProductosComponent, ProductosForm } from './productos/productos.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './login/auth-guard.service';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', redirectTo: '/colores', pathMatch: 'full'},
  { path: '',
    canActivateChild: [AuthGuard],
    children: [
      { path: 'colores', component: ColoresComponent },
      { path: 'coloresForm', component: ColoresForm },
      { path: 'productos', component: ProductosComponent },
      { path: 'productosForm', component: ProductosForm }
    ]
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);
