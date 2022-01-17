import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AuthService } from "../service/auth.service";

@Injectable({
    providedIn:"root"
})
export class DashboardGuard implements CanActivate{

    constructor(private authService:AuthService, private router:Router){

    }
     
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        const loggedIn:boolean=this.authService.isLoggedIn();
        if(!loggedIn){
            this.router.navigate(["/login"]);
            return false;
        }

        return true;
   }

}