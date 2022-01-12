import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  title = 'component-interaction';
  userInput:string|undefined;

  messageFromChild:string="";
 
  toggleChild:boolean=true;

  constructor(){
    console.log("inside parent constructor");
  }
   
   messageReceivedFromChild(receivedMsg:string){
     console.log("message received in parent", receivedMsg);
    this.messageFromChild=receivedMsg;
   }

   ngOnInit(): void {
   console.log("insid eparent, oninit");
  }

  changeChildVisibility():void{
   this.toggleChild=!this.toggleChild;
  }
}
