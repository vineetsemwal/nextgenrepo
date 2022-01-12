import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'component-interaction';
  userInput:string|undefined;

  childEvent1Msg:string="";
  childEvent2Msg:string="";

  childEvent1MsgReceived(receivedMsg:string){
     console.log("message received in parent", receivedMsg);
    this.childEvent1Msg=receivedMsg;

   }


   childEvent2MsgReceived(receivedMsg:string){
    console.log("message received in parent", receivedMsg);
   this.childEvent2Msg=receivedMsg;
  }

}
