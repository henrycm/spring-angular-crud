import { Injectable } from '@angular/core';
import { Router, CanActivate, CanActivateChild, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable()
export class AuthGuard implements CanActivate, CanActivateChild {

  constructor(private authService: AuthService, private router: Router){}

  canActivateChild(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    console.log('AuthGuard#canActivateChildren called');
    return this.checkLogin(state);
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    console.log('AuthGuard#canActivate called');
    return this.checkLogin(state);
  }

  checkLogin(state){
    if( !this.authService.loggedIn()){
      this.router.navigate(['/login'], { queryParams: { returnUrl: state.url }});
      return false;
    }

    return true;
  }
}
