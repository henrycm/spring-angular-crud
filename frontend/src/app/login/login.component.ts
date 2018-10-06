import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
  username: string = "testUsername";
  password: string = "testPassword";
  returnUrl: string;

  constructor(private authService:AuthService, private router: Router, private route: ActivatedRoute) { }

  onSubmit(form: any): void {
    console.log(form)
    this.authService.login(form).subscribe(data => {
      if(data.token != null){
        console.log("loggedIn!");
        this.router.navigate([this.returnUrl]);
      }
    });
  }

  ngOnInit() {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

}
