import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import Employee from '../model/employee';

@Component({
  selector: 'list-employees',
  templateUrl: './list-employees.component.html',
  styleUrls: ['./list-employees.component.css']
})
export class ListEmployeesComponent {


  employees:Employee[];

  constructor(private service:EmployeeService) {
    this.employees=service.getAllEmployees();
   }

    

}
