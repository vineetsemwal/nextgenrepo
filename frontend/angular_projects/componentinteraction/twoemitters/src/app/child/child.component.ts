import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  @Input() parentInput: string | undefined;

  @Output()childEvent1:EventEmitter<string>=new EventEmitter();

  @Output()childEvent2:EventEmitter<string>=new EventEmitter();

  counter:number=0;

  constructor() { }

  ngOnInit(): void {
  }

  onButton1Clicked():void{
     this.counter++;
     this.childEvent1.emit("childevent1 message from child "+this.counter);
  }



  onButton2Clicked():void{
    this.counter++;
    this.childEvent2.emit("childevent2 message from child "+this.counter);
 }


}
