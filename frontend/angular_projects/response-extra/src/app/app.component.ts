import { HttpClient, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import Employee from './employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'response-extra';
  readonly baseUrl="http://localhost:3000";
  emp:Employee|undefined;
  constructor(private client:HttpClient) {

  }
  ngOnInit(): void {
   const obs:Observable<HttpResponse<Employee>> = this.getEmployee("1");
   const observer={
     next: (response:HttpResponse<Employee>)=>{
      console.log("status code",response.status);
      console.log("headers",response.headers);
      if(response.body!=null)
        this.emp=response.body;
      }
     
    }
   obs.subscribe(observer);

  }

   getEmployee(id:string):Observable<HttpResponse<Employee>>{
    const url=this.baseUrl+"/employees/"+id;
    const obs:Observable<HttpResponse<Employee>> =this.client.get<Employee>(url,{"observe":"response"});
    return obs;
   }

}
