import {Component} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username:string;
  password:string;

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

  public isLogInDisabled = () => {
    return this.username && this.password;
  }
}
