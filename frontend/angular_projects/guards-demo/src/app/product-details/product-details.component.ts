import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  constructor(private service:ProductService, private route:ActivatedRoute) { }

   product:Product|undefined;

  ngOnInit(): void {
   const observer={next: (map:ParamMap)=>{
   const idStr:string|null=  map.get("id");
   if(idStr!=null){
   const id:number=parseInt(idStr);
   this.product = this.service.findProductById(id);
   }  
  }}; 
   this.route.paramMap.subscribe(observer);   
   
  }

}
