import { Component, OnInit } from '@angular/core';
import { Observable, Observer } from 'rxjs';
import { Employee } from '../model/employee';
import { AuthService } from '../service/auth.service';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  emp:Employee|undefined;

  constructor(private empService:EmployeeService,private authService:AuthService) { }

  ngOnInit(): void {
   const username:string|null =this.authService.getUser();
   if(username==null){
     throw new Error("username not found");
   }
   const observable:Observable<Employee>=this.empService.fetchEmployeeByUsername(username);
   const observer:Observer<Employee>={
     next: (result:Employee)=>{
      console.log("result in Dasboard",result); 
      this.emp=result;
    },
    error:(err:Error)=>{
      console.log(err);
    },
    complete:()=>console.log("complete")
  }

  observable.subscribe(observer);

}

}
