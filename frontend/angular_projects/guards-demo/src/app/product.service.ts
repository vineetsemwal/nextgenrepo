import { Injectable } from '@angular/core';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  products:Product[]=[
    {id:1,name:"samsung"},
    {id:2,name:"motorolla"}
    
  ]

  constructor() { }

   findProductById(id:number):Product{
     for (let product of this.products){
        if(id===product.id){
          return product;
        }
     }
     throw new Error("product not found");
   }


}
