import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  @Input() parentInput: string | undefined;

  @Output()childEvent:EventEmitter<string>=new EventEmitter();

  counter:number=0;

  constructor() { }

  ngOnInit(): void {
  }

  onButtonClicked():void{
     this.counter++;
     this.childEvent.emit("message from child "+this.counter);
  }

}
