import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ChildComponent } from './child/child.component';
import { Child2Component } from './child2/child2.component';
import { Child3Component } from './child3/child3.component';
import { Child4Component } from './child4/child4.component';

@NgModule({
  declarations: [
    AppComponent,
    ChildComponent,
    Child2Component,
    Child3Component,
    Child4Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
