import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, Observer, Subscription } from 'rxjs';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {


  formGroup: FormGroup;
  usernameCtrl: FormControl;
  passwordCtrl: FormControl;
  subscription:Subscription|undefined;

  constructor(private authService:AuthService, private router: Router, builder: FormBuilder) {
    this.usernameCtrl = builder.control('');
    this.passwordCtrl = builder.control('');
    this.formGroup = builder.group({
      "username": this.usernameCtrl,
      "password": this.passwordCtrl
    });
  }
  

  ngOnInit(): void {
  }
  ngOnDestroy(): void {
   if(this.subscription!=null){
     this.subscription.unsubscribe();
   }
  }

  onFormSubmit() {
    const obs: Observable<string> = this.authService.login(this.usernameCtrl.value, this.passwordCtrl.value);
    const observer: Observer<string> = {
      next: (token: string) => {
        this.authService.saveToken(token);
        this.router.navigate(["/dashboard"]);
    }
      ,
      error: (err: Error) => {
        console.log("error while trying tot login", err);
      }
      ,
      complete: () => console.log("completed")

    };

    this.subscription=obs.subscribe(observer);
  }

}
