import { Injectable } from "@angular/core";
import { Observable } from "rxjs";


@Injectable({
  providedIn:"root"
})
export class TimeService{
   

  getTime():Observable<Date>{
    const obs:Observable<Date>=new Observable<Date>(subscriber=>{
      setInterval(()=>{
        const date=new Date();  
        console.log("publishing date time",date);
        subscriber.next(date);
      },5000);
    });
    return obs;
  }
}