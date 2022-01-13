import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEmployeeReactiveComponent } from './add-employee-reactive/add-employee-reactive.component';
import { ListEmployeesComponent } from './list-employees/list-employees.component';

const routes: Routes = [

  {path:"listall",component:ListEmployeesComponent},

  {path:"add" , component:AddEmployeeReactiveComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
