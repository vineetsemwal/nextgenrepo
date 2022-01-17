import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, Observer, Subscription } from 'rxjs';
import { EmployeeService } from '../employee.service';
import Employee from '../model/employee';

@Component({
  selector: 'list-employees',
  templateUrl: './list-employees.component.html',
  styleUrls: ['./list-employees.component.css']
})
export class ListEmployeesComponent implements OnInit, OnDestroy {


  employees:Employee[]=[];
  errMsg:string|undefined; 
  errorReceived:boolean=false;
  subscription:Subscription|undefined;
  constructor(private service:EmployeeService) {
   }
  

  ngOnInit(): void {
    const observable:Observable<Employee[]> =this.service.fetchAllEmployees();
    const observer:Observer<Employee[]>={
      next: (result:Employee[])=>{
        this.errorReceived=false;
        this.employees=result;
        console.log("result received", result);
      },
      error: (err:Error)=>{
        this.errorReceived=true;
        this.errMsg=err.message;
        console.error("error received",err );
      } ,
      complete:()=>{
        console.log("completed");
      }
    };

    this.subscription=observable.subscribe(observer);
  }

  ngOnDestroy(): void {
    if(this.subscription){
    this.subscription.unsubscribe();
    }
  }

    

}
