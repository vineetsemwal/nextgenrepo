import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { GreetingPayload } from '../common/greetingpayload';

@Component({
  selector: 'child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  @Input() parentInput: string | undefined;

  @Output()childEvent:EventEmitter<GreetingPayload>=new EventEmitter();


  constructor() { }

  ngOnInit(): void {
  }

  onButtonClicked(dayTime:string, greetingMsg:string):void{
     let payload:GreetingPayload=new GreetingPayload(dayTime,greetingMsg); 
     this.childEvent.emit(payload);
  }


}
