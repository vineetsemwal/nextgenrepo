import { Component, OnDestroy, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Observable, Observer, Subscription } from 'rxjs';
import { forbiddenAgeValidator } from '../common/forbiddenAgeValidator';
import { EmployeeService } from '../employee.service';
import Employee from '../model/employee';

@Component({
  selector: 'add-employee-reactive',
  templateUrl: './add-employee-reactive.component.html',
  styleUrls: ['./add-employee-reactive.component.css'],
})
export class AddEmployeeReactiveComponent implements OnInit, OnDestroy {
  nameCtrl: FormControl;
  ageCtrl: FormControl;
  myform: FormGroup;
  employeeAdded = false;
  emp = new Employee('', undefined);
   result:Employee|undefined;
  errMsg:string|undefined;
  subscription:Subscription|undefined;

   constructor(builder: FormBuilder, private service:EmployeeService) {
    this.nameCtrl = builder.control('', [Validators.required]);
    this.ageCtrl = builder.control('', [forbiddenAgeValidator(21, 60)]);
    this.myform = builder.group({
      empName: this.nameCtrl,
      empAge: this.ageCtrl,
    });
  }
 
  ngOnDestroy(): void {
    if(this.subscription)
    {
      this.subscription.unsubscribe();
  }
}

  ngOnInit() {
    console.log("inside init,form", this.myform);
  }
  
 

  isAgeValidationError(): boolean {
    if (!this.isCommonValidationErr(this.ageCtrl)) {
      return false;
    }

    return this.ageCtrl.errors != null && this.ageCtrl.errors['forbiddenAge']
  }

  isNameValidationError(): boolean {
    if (!this.isCommonValidationErr(this.nameCtrl)) {
      return false;
    }
    return this.nameCtrl.errors != null && this.nameCtrl.errors['required'];
  }

  isCommonValidationErr(checkFor: FormControl) {
    if (!checkFor.touched && !checkFor.dirty) {
      return false;
    }
    return true;
  }

  getAgeValidationError() {
    if (this.ageCtrl.errors == null) {
      return "";
    }
    const errors = this.ageCtrl.errors;
    const forbiddenErrObj=errors['forbiddenAge']
    if(forbiddenErrObj==null){
      return "";
    }
    const value = forbiddenErrObj.value;
    if (value == null) {
      return "";
    }
    return value;
  }

  addEmployee(): void {
    console.log(this.myform);
    if (!this.myform.valid) {
      this.myform.markAllAsTouched();
      return;
    }
    const name = this.nameCtrl.value;
    const age = this.ageCtrl.value;
    this.emp.empAge = age;
    this.emp.empName = name;
    const obs:Observable<Employee>=this.service.add(this.emp);
    const observer:Observer<Employee>={
     next: (receivedResult:Employee)=>{
       console.log("****result received in add component",receivedResult);
      this.result=receivedResult;
      this.emp=new Employee('',undefined); 
     },
     error:(err:Error)=>{
       console.error("error received",err);

     },
     complete: ()=>console.log("completed")
    };
    this.subscription= obs.subscribe(observer);
  
    console.log('employee', this.emp);
    this.employeeAdded = true;
  }
}
