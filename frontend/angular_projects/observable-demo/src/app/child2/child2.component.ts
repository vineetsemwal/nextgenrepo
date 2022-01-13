import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'child2',
  templateUrl: './child2.component.html',
  styleUrls: ['./child2.component.css']
})
export class Child2Component implements OnInit {

  constructor() { }


  ngOnInit(): void {
    console.log("task assigned");  
    console.log("started progress dialog when task is assigned");
    const obs:Observable<number>=this.doTask();
    console.log("before subscribed");

    const observer={
      next: (result:number)=>{
        console.log("received result",result);
     }
     ,
     error: (err:Error)=>{
        console.log("error received", err);  
     } 
     ,
    complete:()=>{
      console.log("completed, hiding progress dialog");
    }
    };
    
    obs.subscribe(observer);
   
    
      console.log("after subscribed")
  }


  doTask():Observable<number>{
    
    const obs:Observable<number>=new Observable<number>(subscriber=>{
      console.log("about to publish",10)
      subscriber.next(10);
      console.log("about to publish",11)
      subscriber.next(11);
      console.log("about to publish",12);    
      subscriber.next(12);
      console.log("about to publish",13);    
      subscriber.next(13);
      subscriber.complete();
    }); 
     return obs;
  }
  
 
}
