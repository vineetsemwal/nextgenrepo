import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title: string = 'welcome';

  emp: Employee[] = [new Employee(10, 'vinay'), new Employee(11, 'remjith')];
  greeting(): string {
    return 'Good afternoon';
  }
}
class Employee {
  constructor(public id: number, public name: string) {}
}
