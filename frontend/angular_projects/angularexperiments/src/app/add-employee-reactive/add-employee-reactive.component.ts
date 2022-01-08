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
export class AddEmployeeReactiveComponent {
  nameCtrl: FormControl;
  ageCtrl: FormControl;
  myform: FormGroup;
  employeeAdded = false;
  emp = new Employee('', 0);

  constructor(builder: FormBuilder) {
    this.nameCtrl = builder.control('', [Validators.required]);
    this.ageCtrl = builder.control('', [forbiddenAgeValidator]);
    this.myform = builder.group({
      empName: this.nameCtrl,
      empAge: this.ageCtrl,
    });
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
