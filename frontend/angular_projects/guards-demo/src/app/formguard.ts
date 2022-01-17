import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AddProductComponent } from "./add-product/add-product.component";
import { IFormHolder } from "./iformholder";

@Injectable({
    providedIn:"root"
})
export class FormGuard implements CanDeactivate<IFormHolder>{
   
    canDeactivate(component: IFormHolder, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): boolean  {
        const formGroup=component.getFormGroup();
        const isDirty:boolean=formGroup.dirty;
        console.log("is form dirty",isDirty);
        if(!isDirty){
           return true;
       }

       return confirm("Do you want to leave?");
    }

}