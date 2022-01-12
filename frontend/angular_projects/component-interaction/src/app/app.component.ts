import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'component-interaction';
  userInput:string|undefined;

  messageFromChild:string="";

   messageReceivedFromChild(receivedMsg:string){
     console.log("message received in parent", receivedMsg);
    this.messageFromChild=receivedMsg;
   }

}
