import { HttpClient } from '@angular/common/http';
import {TestBed } from '@angular/core/testing';
import {HttpClientTestingModule, HttpTestingController, TestRequest } from '@angular/common/http/testing';

import { EmployeeService } from './employee.service';
import { Employee } from './employee';
import { Observable } from 'rxjs';

describe('EmployeeService', () => {
  let service: EmployeeService;
  let client:HttpTestingController; 
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule]
    });        
    client=TestBed.inject(HttpTestingController);
    service = TestBed.inject(EmployeeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it("fetchEmployeeById, id is 1",()=>{
    const url="http://localhost:3000/employees/1";
    const emp:Employee=new Employee("1","remjith",26);
    const obs:Observable<Employee>=service.fetchEmployeeById("1");
    obs.subscribe({
      next: (result:Employee)=>{
        expect(result).toEqual(emp);
      }
    });
 
    const testRequest:TestRequest=client.expectOne(url);
    testRequest.flush(emp); 
    expect(testRequest.request.method).toBe("GET");

  });
});
