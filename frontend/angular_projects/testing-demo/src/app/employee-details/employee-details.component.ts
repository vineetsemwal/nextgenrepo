import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
  title="employee details";
  emp:Employee|undefined; 
  counter:number=0;
  constructor(private service:EmployeeService) { }

  ngOnInit(): void {
   let obs:Observable<Employee>=this.service.fetchEmployeeById("1");
   obs.subscribe({next: (result:Employee)=>{
     this.emp=result
    console.log("employee set in the field",this.emp);   
    }
    });

  }

  increment(){
    this.counter++;
  }

}
