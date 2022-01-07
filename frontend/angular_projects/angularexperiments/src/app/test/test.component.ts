import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'test-cmp',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent  {

  testDesc:string="Test Component";

  greet:string="test component greets";
  isHidden:boolean=false;
linkUrl="http://google.com";

 counter:number=0;

 textInputValue:string="";

 textInput2:string="";

  constructor() { }

  increment(){
   this.counter++;
  }

  inputValueBtnClick(value:any){
    this.textInputValue=value;
  }

}
