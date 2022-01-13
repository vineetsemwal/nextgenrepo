import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Employee from './model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  readonly baseUrl:string="http://localhost:3000";

  constructor(private client:HttpClient) { }

  add(employee:Employee):Observable<Employee>{
    console.log("***inside service add ,request data",employee );
    const url=this.baseUrl+"/employees";
    const obs:Observable<Employee>=this.client.post<Employee>(url,employee);
    return obs;
  }


  fetchAllEmployees():Observable<Employee[]>{
    console.log("*******inside fetch all employees");
    const url=this.baseUrl+"/employees";
    const obs:Observable<Employee[]>=this.client.get<Employee[]>(url);
    return obs;
  }

  findEmployeeById(id:string):Observable<Employee>{
    const url=`${this.baseUrl}/employees/${id}`;
    const obs:Observable<Employee>=this.client.get<Employee>(url);
    return obs; 
  }


}
