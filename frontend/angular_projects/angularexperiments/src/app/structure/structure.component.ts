import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'structure',
  templateUrl: './structure.component.html',
  styleUrls: ['./structure.component.css'],
})
export class StructureComponent implements OnInit {
  constructor() {}

  value: number = 12;

  fruits = ['apple', 'mango', 'banana'];

  employees = [
    new Employee(1, 'remjith'),
    new Employee(2, 'vinay'),
    new Employee(3, 'deepak'),
    new Employee(4, 'karthik'),
  ];

  ngOnInit(): void {}
}
class Employee {
  constructor(public empId: number, public empName: string) {}
}
