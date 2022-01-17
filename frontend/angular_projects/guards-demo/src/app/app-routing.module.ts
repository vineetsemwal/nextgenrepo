import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddProductComponent } from './add-product/add-product.component';
import { FormGuard } from './formguard';
import { NotFoundComponent } from './not-found/not-found.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { UrlGuard } from './urlguard';

const routes: Routes = [

  {
    path:"add", component:AddProductComponent,canDeactivate:[FormGuard]
  },
  {
    path:"details/:id", component:ProductDetailsComponent, canActivate:[UrlGuard]
  },
  {
    path:"notfound", component:NotFoundComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
