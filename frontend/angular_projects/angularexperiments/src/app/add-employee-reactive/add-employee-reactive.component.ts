import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import Employee from '../model/employee';

@Component({
  selector: 'add-employee-reactive',
  templateUrl: './add-employee-reactive.component.html',
  styleUrls: ['./add-employee-reactive.component.css']
})
export class AddEmployeeReactiveComponent  {

  nameCtrl:FormControl;
  ageCtrl:FormControl;
  myform:FormGroup;
  employeeAdded=false;
  emp=new Employee('',0);
  constructor(builder:FormBuilder) { 
    this.nameCtrl=builder.control('');
    this.ageCtrl=builder.control('');
    this.myform=builder.group({"empName":this.nameCtrl, "empAge":this.ageCtrl});
  }
  addEmployee():void{
    console.log(this.myform);
    const name=this.nameCtrl.value;
    const age=this.ageCtrl.value;
    this.emp.empAge=age;
    this.emp.empName=name;
    console.log("employee",this.emp);
    this.employeeAdded=true; 
   }


}
