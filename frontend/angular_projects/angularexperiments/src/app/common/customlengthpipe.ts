import { Pipe, PipeTransform } from "@angular/core";


@Pipe({'name':'stringlength', pure:true})
export class CustomLengthPipe implements PipeTransform{
 

transform(input:string):number{
    if(!input){
        return 0;
    }
 return input.length;
}

}