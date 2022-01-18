import { HttpClient, HttpClientModule } from '@angular/common/http';
import {TestBed } from '@angular/core/testing';
//import {HttpClientTestingModule, HttpTestingController, TestRequest } from '@angular/common/http/testing';

import { EmployeeService } from './employee.service';
import { Employee } from './employee';
import { Observable, Subscriber } from 'rxjs';
import { Injectable } from '@angular/core';

describe('EmployeeService', () => {
  let service: EmployeeService;
  let client:MockHttpClient; 
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientModule],
      providers:[{provide:HttpClient, useClass:MockHttpClient}]
    });        
    client=TestBed.inject(MockHttpClient);
    service = TestBed.inject(EmployeeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it("custom mock fetchEmployeeById, id is 1",()=>{
    const url="http://localhost:8080/employees/1";
    const emp:Employee=new Employee("1","remjith",26);
    const obs:Observable<Employee>=service.fetchEmployeeById("1");
    obs.subscribe({
      next: (result:Employee)=>{
          console.log("custom verifying result");
        expect(result).toEqual(emp);
        
      }
    });
 
    
    const resultObs:Observable<Employee> = new Observable<Employee>(subscriber=>{
        subscriber.next(emp);
    });
   spyOn(client,'get').withArgs(url).and.returnValue(resultObs);
  
  });
});

@Injectable({providedIn:"root"})
class MockHttpClient{

    get(url:string):Observable<Employee>{
        const resultObs:Observable<Employee> = new Observable<Employee>(subscriber=>{
        });
        return resultObs;
    }
}