import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.css']
})
export class PipesComponent  {

 emp={'empId':1, 'empName':'vinay'};

 date=new Date();

 strings=['red','orange','blue', 'green'];

 numbers=[1,2,3,4,5];

  str1:string="good";
  constructor() { }

addNumber(){
  const newNum=this.numbers.length+1;
  this.numbers.push(newNum); 
  this.numbers=[...this.numbers];
}

}
