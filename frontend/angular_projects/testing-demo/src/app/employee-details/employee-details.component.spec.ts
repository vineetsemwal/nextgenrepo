import { DebugElement, Injectable } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { Observable, Subscriber } from 'rxjs';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

import { EmployeeDetailsComponent } from './employee-details.component';


let fetchEmployeesSubscriber:Subscriber<Employee>;
describe('EmployeeDetailsComponent', () => {
  let component: EmployeeDetailsComponent;
  //useful for debugging and testing component
  let fixture: ComponentFixture<EmployeeDetailsComponent>;
  let debugElement:DebugElement;
   let service:MockEmployeeService;
  beforeEach(async () => {

    await TestBed.configureTestingModule({
      providers:[{provide:EmployeeService, useClass:MockEmployeeService}],
      declarations: [ EmployeeDetailsComponent ]
    })
    .compileComponents();
  
 fixture = TestBed.createComponent(EmployeeDetailsComponent);
 service=TestBed.inject(MockEmployeeService);
 component = fixture.componentInstance;
    debugElement=fixture.debugElement;
  
    fixture.detectChanges();

  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it("EmployeeDetails render", ()=>{
  
    const emp:Employee=new Employee("1","remjith",21);
    fetchEmployeesSubscriber.next(emp);
    fixture.detectChanges();  
 
  expect(debugElement.query(By.css("#title")).nativeElement.textContent.trim()).toBe(component.title);
  expect(debugElement.query(By.css("#empId")).nativeElement.textContent.trim()).toBe("1");
  expect(debugElement.query(By.css("#empName")).nativeElement.textContent.trim()).toBe("remjith");
  const empAgeContent=debugElement.query(By.css("#empAge")).nativeElement.textContent;
  console.log("emp age content",empAgeContent);
  expect(empAgeContent.trim()).toBe("21");
  
  
});

});

@Injectable({
  providedIn:"root"
})
class MockEmployeeService{
  fetchEmployeeById(id:string):Observable<Employee>{
    const emp:Employee=new Employee("1","remjith",21);   
    const obs:Observable<Employee>=new Observable<Employee>(subscriber=>{
      fetchEmployeesSubscriber=subscriber;
    });
     return obs;
  }
}
