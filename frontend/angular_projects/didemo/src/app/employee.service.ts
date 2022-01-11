import { Injectable } from '@angular/core';
import Employee from './model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

   store:Employee[]=[]

  constructor() { }

  add(employee:Employee):void{
   this.store.push(employee);
  }


  getAllEmployees():Employee[]{
    return this.store;
  }

}
