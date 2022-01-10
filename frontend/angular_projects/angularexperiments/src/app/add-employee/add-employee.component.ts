import { Component, OnInit } from '@angular/core';
import Employee from '../model/employee';

@Component({
  selector: 'add-employee-templatedriven',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent  {

  emp=new Employee("", 0);
  employeeAdded:boolean=false;

  constructor() { }

   addEmployee(myform:any):void{
   console.log(myform);
   if (!myform.valid) {
    myform.form.markAllAsTouched();
    return;
  }
   //const name=myform.value.empName;
   //const age=myform.value.empAge;
   //this.emp.empAge=age;
   //this.emp.empName=name;
   console.log("employee",this.emp);
   this.employeeAdded=true; 
  }

}