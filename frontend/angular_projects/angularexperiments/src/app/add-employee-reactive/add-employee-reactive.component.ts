import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { forbiddenAgeValidator } from '../common/forbiddenAgeValidator';
import Employee from '../model/employee';

@Component({
  selector: 'add-employee-reactive',
  templateUrl: './add-employee-reactive.component.html',
  styleUrls: ['./add-employee-reactive.component.css'],
})
export class AddEmployeeReactiveComponent implements OnInit {
  nameCtrl: FormControl;
  ageCtrl: FormControl;
  myform: FormGroup;
  employeeAdded = false;
  emp = new Employee('', 0);

  constructor(builder: FormBuilder) {
    this.nameCtrl = builder.control('', [Validators.required]);
    this.ageCtrl = builder.control('', [forbiddenAgeValidator(21, 60)]);
    this.myform = builder.group({
      empName: this.nameCtrl,
      empAge: this.ageCtrl,
    });
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
    console.log('employee', this.emp);
    this.employeeAdded = true;
  }
}
