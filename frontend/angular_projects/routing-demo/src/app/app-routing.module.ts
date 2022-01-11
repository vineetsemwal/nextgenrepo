import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeNotfoundComponent } from './employee-notfound/employee-notfound.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [
  
  { path: "", redirectTo: "home", pathMatch: "full" },
  { path: "about", component: AboutUsComponent },

  { path: "contact", component: ContactUsComponent },

  { path: "home", component: HomeComponent },

  {path:"employee", component:EmployeeDetailsComponent,pathMatch:"full"},

  {path:"employee/id/**", component:EmployeeNotfoundComponent,pathMatch:"prefix"},

  {path:"**", component:NotFoundComponent}

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
