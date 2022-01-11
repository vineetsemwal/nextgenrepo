import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEmployeeReactiveComponent } from './add-employee-reactive.component';

describe('AddEmployeeReactiveComponent', () => {
  let component: AddEmployeeReactiveComponent;
  let fixture: ComponentFixture<AddEmployeeReactiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEmployeeReactiveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEmployeeReactiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
