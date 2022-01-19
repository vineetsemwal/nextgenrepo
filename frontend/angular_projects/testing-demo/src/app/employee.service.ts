import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private client:HttpClient) { }

  fetchEmployeeById(id:string):Observable<Employee>{
    console.log("client is ", this.client);
    const url="http://localhost:3000/employees/"+id;
    const obs:Observable<Employee>=this.client.get<Employee>(url);
     return obs;
  }

}
