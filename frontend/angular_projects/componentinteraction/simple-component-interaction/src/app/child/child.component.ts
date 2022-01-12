import { AfterContentInit, AfterViewInit, Component, ContentChild, DoCheck, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChange, SimpleChanges, ViewChild } from '@angular/core';


/**
 *  constructor executed when even component instantiated
 *  ngOnInit : like constructor executed only 1 time, is a recommended place for initialization
 *  ngOnChanges: gets executed after every change in the input bound property, 
 *  we get simplechanges object from which we can see previous and the current value 
 *  docheck: invoked when change detector of component is executed, called after onchange on every change detection run,
 * you can use it to try detecting change in component but be careful on every doCheck invoke doesn't guarantee a change 
 * ngAfterContentInt: called after extenal content has been attached
 * ngAfterViewInit:  called after Angular has fully initialized a component's view
 * 
 */

@Component({
  selector: 'child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements
  OnInit, OnDestroy, OnChanges, DoCheck, AfterContentInit, AfterViewInit {

  @Input() parentInput: string | undefined;

  @Output() childEvent: EventEmitter<string> = new EventEmitter();

  counter: number = 0;

  subscriptionId: any | undefined;

  intervalCounter: number = 0;

  @ContentChild("projectedContent") projectedContent:any;

  @ViewChild("childContent") childContent:any;

  constructor() {
    console.log("inside child constructor");
  }
 
  
  ngOnInit(): void {
    console.log("inside child ngOnInint",this.projectedContent);
    this.subscriptionId = setInterval(() => {
      this.intervalCounter++;
      console.log("getting executed after every sec " + this.intervalCounter);
    }, 10000);
  }

  onButtonClicked(): void {
    this.counter++;
    this.childEvent.emit("message from child " + this.counter);
  }


  ngOnDestroy(): void {
    console.log("inside child ngondesroy");
    clearInterval(this.subscriptionId);
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log("inside ngOnchanges");
    let change: SimpleChange = changes['parentInput'];
    console.log("previous value", change.previousValue, "current value", change.currentValue);
  }

  ngDoCheck(): void {
    console.log("inside child's docheck");
  }

  ngAfterContentInit(): void {
    console.log("inside after content init",this.projectedContent);
  }

  ngAfterViewInit(): void {
    console.log("inside afterviewinit", this.childContent);
  }


}
