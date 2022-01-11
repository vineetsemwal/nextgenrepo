import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeNotfoundComponent } from './employee-notfound.component';

describe('EmployeeNotfoundComponent', () => {
  let component: EmployeeNotfoundComponent;
  let fixture: ComponentFixture<EmployeeNotfoundComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeNotfoundComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeNotfoundComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
