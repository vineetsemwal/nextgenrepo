import { DebugElement, Injectable } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

import { EmployeeDetailsComponent } from './employee-details.component';

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
    service=TestBed.inject(MockEmployeeService);
    fixture = TestBed.createComponent(EmployeeDetailsComponent);
    component = fixture.componentInstance;
    debugElement=fixture.debugElement;
  
    fixture.detectChanges();

  });
/*
  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeDetailsComponent);
    component = fixture.componentInstance;
    debugElement=fixture.debugElement;
  });
*/
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it("EmployeeDetails render", ()=>{
 /*   
    const emp:Employee=new Employee("1","remjith",21);
     const obs:Observable<Employee>=new Observable<Employee>(subscriber=>{
   subscriber.next(emp);
  });
  fixture.detectChanges(); 
  
  spyOn(service,'fetchEmployeeById').and.returnValue(obs);  
  */
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
      subscriber.next(emp);
     });
     return obs;
  }
}
