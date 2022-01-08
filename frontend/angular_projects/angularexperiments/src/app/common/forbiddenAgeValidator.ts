import { AbstractControl } from "@angular/forms";

export function forbiddenAgeValidator(control:AbstractControl):any{
console.log("inside forbiddenAgeValidator");
const value=control.value;
const forbidden=value<21 || value>60;
return forbidden?{forbiddenAge:{value:value}}:null;
}