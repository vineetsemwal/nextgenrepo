import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'attributes',
  templateUrl: './attributes.component.html',
  styleUrls: ['./attributes.component.css']
})
export class AttributesComponent {

  constructor() { }
  cssCla="box";
 arr=["box", "pad"];
 num=20;

 elementStyle1={'background-color':"green",'color':"white"};


 elementStyle2={'background-color':"yellow",'color':"white"};

}
