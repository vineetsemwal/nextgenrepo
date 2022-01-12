import { Component } from '@angular/core';
import { GreetingPayload } from './common/greetingpayload';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'component-interaction';
  userInput:string|undefined;

  

  dayTime:string="";
  greetingMsg:string="";

   messageReceivedFromChild(payload:GreetingPayload){
     console.log("message received in parent", payload);
    this.greetingMsg=payload.msg;
    this.dayTime=payload.dayTime;
 
   }

}
