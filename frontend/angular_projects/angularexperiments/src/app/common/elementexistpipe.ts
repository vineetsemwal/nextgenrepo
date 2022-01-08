import { Pipe, PipeTransform } from "@angular/core";


@Pipe({'name':'exists',pure:true})
export class ElementExistsPipe implements PipeTransform{

transform(elements:any[], element:any ):boolean{
   console.log("inside Element Exists pipe, check for element="+element);
    if(!element){
        return false;
    }
    if(!elements){
        return false;
    }

  for(let iterated of elements){
      if(iterated===element){
        return true;
      }
  }
  return false;
}

}