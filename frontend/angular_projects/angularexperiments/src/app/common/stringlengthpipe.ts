import { Pipe, PipeTransform } from "@angular/core";


@Pipe({'name':'stringlength'})
export class StringLengthPipe implements PipeTransform{
 

transform(input:string):number{
    if(!input){
        return 0;
    }
 return input.length;
}

}