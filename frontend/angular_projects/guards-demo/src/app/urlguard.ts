import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";

@Injectable({providedIn:"root"})
export class UrlGuard implements CanActivate{

    constructor(private router:Router){

    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
      const id:any= route.paramMap.get("id");
      console.log("inside urlguard canactivate id",id);
      if(id==null){
      //navigate user to not found if id is not present
       this.router.navigate(["/notfound"]);
       return false;
      }
      const isNotNumber=isNaN(id);
      if(isNotNumber){
        this.router.navigate(["/notfound"]);
        return false;
      }
      return true;

    }

}