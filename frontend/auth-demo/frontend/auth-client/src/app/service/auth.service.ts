import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { baseUrl } from '../common/constants';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private client:HttpClient) { }


  login(username:string,password:string):Observable<string>{
     const url=baseUrl+"/login";
     const requestData={"username":username, "password":password};    
     this.saveUser(username); 
     const obs:Observable<string>=this.client.post<string>(url,requestData,{responseType:"text" as any});
     return obs;
  }

  saveUser(username:string):void{
   localStorage.setItem("user",username);
  }

  getUser():string|null{
    return localStorage.getItem("user");
  }

  saveToken(token:string):void{
    localStorage.setItem("token",token);
  }

  getToken():string|null{
   return localStorage.getItem("token");
  }

  isLoggedIn():boolean{
   const token:string|null= this.getToken();
   return token!=null;
  }

  logout(){
    localStorage.removeItem("user");
    localStorage.removeItem("token");
  }

}
