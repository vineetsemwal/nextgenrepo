import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

@Component({
  selector: 'child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  constructor() { }

  addResult:number|undefined;

  ngOnInit(): void {
    console.log("task assigned");  
   // let obs:Observable<number>=this.add(10,20);
   let obs:Observable<number>=this.add(undefined,undefined);
   console.log("about to subscribe")
    obs.subscribe(
          (result:number)=>{
           this.addResult=result;
           console.log("result received",result);
          },
          err=>{
            console.log("received err",err);
          }
      );

     console.log("subscribed"); 
      
  }

  
  add(num1:number, num2:number):Observable<number>{
  let obs:Observable<number>=new Observable<number>(subscriber=>{
       if(!num1 ||!num2){
         subscriber.error(new Error("num1 or num2 is invalid"));
      }
      let sum=num1+num2;
      console.log("about to publish result");
      subscriber.next(sum);  
      console.log("result already published");
  });
  return obs;
  }

}