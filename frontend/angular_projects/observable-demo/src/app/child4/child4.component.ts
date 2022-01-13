import { Component, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { TimeService } from '../time.service';

@Component({
  selector: 'child4',
  templateUrl: './child4.component.html',
  styleUrls: ['./child4.component.css']
})
export class Child4Component implements OnInit, OnDestroy {
 subscription:Subscription|undefined;
   date:Date|undefined;
  

  constructor(private service:TimeService) { }


  ngOnInit(): void {
    const obs:Observable<Date> =this.service.getTime();
     const observer={
      next: (result:Date)=>{
        this.date = result;
        console.log("date time received",result);
      }
     };
   this.subscription =obs.subscribe(observer);   
    

    }

    ngOnDestroy(){
      this.subscription.unsubscribe();
      console.log("unsubscribed");
    }



}
