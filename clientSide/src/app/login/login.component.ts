import {Component} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthService} from "../core/auth.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private authService: AuthService, private router: Router) {
  }

  usernameFromControl = new FormControl('', [
    Validators.required
  ]);

  passwordFormControl = new FormControl('', [
    Validators.required
  ]);

  loginForm = new FormGroup({
    username: this.usernameFromControl,
    password: this.passwordFormControl
  });

  public logIn() {
    this.authService.logIn(this.loginForm.value.username, this.loginForm.value.password)
      .subscribe(
        data => this.router.navigate(['/main'])
      )
  }
}
