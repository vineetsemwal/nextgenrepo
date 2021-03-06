import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardGuard } from './common/dahboard.guard';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [

  {
    path:"login", component:LoginComponent
  }
  ,
  {
    path:"dashboard", component:DashboardComponent, canActivate:[DashboardGuard]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
