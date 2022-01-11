import { Directive } from "@angular/core";
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator, ValidatorFn, Validators } from "@angular/forms";



export function forbiddenAgeValidator(min: number, max: number):ValidatorFn {
    return (control: AbstractControl) => {
        console.log("inside forbiddenAgeValidator , min="+min+" "+max);
        const value = control.value;
        const forbidden = value < min || value > max;
        return forbidden ? { forbiddenAge: { value: value + " not between 21 and 60" } } : null;
    }
}


@Directive({
    selector:'[forbiddenAgeDirective]',
    providers:[
        {provide:NG_VALIDATORS,useExisting:ForbiddenAgeValidatorDirective,multi: true}
    ]
})

export class ForbiddenAgeValidatorDirective implements Validator{
    validate(control: AbstractControl): ValidationErrors | null {
        console.log("inside ForbiddenAgeValidatorDirective" );
        const value = control.value;
        const forbidden = value < 21 || value > 60;
        return forbidden ? { forbiddenAge: { value: value + " not between 21 and 60" } } : null;
    }

    
}