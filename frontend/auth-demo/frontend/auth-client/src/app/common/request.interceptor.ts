import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { AuthService } from "../service/auth.service";

@Injectable({
    providedIn:"root"
})
export class RequestInterceptor implements HttpInterceptor{
    
    constructor(private authService:AuthService){

    }
    
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
      const token:string|null= this.authService.getToken();
      if(token==null){
         return next.handle(request);
      }
      const headers:HttpHeaders=new HttpHeaders({"token":token});
      const clonedRequest=request.clone({headers});
      return next.handle(clonedRequest);
    }
    
}