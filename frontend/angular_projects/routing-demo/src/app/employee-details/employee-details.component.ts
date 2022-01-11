import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  empId:number|undefined;

  constructor(private route:ActivatedRoute) { }

  ngOnInit(): void {
    console.log("inside employee detail Component onininit");
   const observable:Observable<ParamMap> =this.route.paramMap;
   observable.subscribe(map=>{
    const id:string=map.get("id");
    console.log("console.log result recived id ",id);
    this.empId=parseInt(id);
   }  );
  }

}
