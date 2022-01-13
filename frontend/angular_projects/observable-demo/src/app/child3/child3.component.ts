import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'child3',
  templateUrl: './child3.component.html',
  styleUrls: ['./child3.component.css']
})
export class Child3Component implements OnInit {

  constructor() { }

 
  addResult:number|undefined;

  ngOnInit(): void {
    console.log("task assigned");  
    let obs:Observable<number>=this.add(10,20);
    console.log("about to subscribe")
    obs.subscribe(
          (result:number)=>{
           this.addResult=result;
           console.log("result received",result);
          }
      );

     console.log("subscribed"); 
      
  }

  
  add(num1:number, num2:number):Observable<number>{
  let obs:Observable<number>=new Observable<number>(subscriber=>{
    setTimeout(()=>{
      let sum=num1+num2;
      console.log("about to publish result");
      subscriber.next(sum);  
      console.log("result already published");
    }, 10000);
  });
  console.log("returning observable");
  return obs;
  }

}
