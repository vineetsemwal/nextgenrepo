import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { baseUrl } from '../common/constants';
import { Employee } from '../model/employee';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private client:HttpClient, private authService:AuthService) { }

  fetchEmployeeByUsername(username:string):Observable<Employee>{
    const token:string|null=this.authService.getToken();
    if(token==null){
      return new Observable(subscriber=>subscriber.error("user not logged in"));
    }
    const url=baseUrl+"/employees/byusername/"+username ;
    //const options={headers:{"token":token}};
    const obs:Observable<Employee>=this.client.get<Employee>(url);
    return obs;
  }

}
