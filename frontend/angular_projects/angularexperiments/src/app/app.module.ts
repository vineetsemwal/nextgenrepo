import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TestComponent } from './test/test.component';
import { StructureComponent } from './structure/structure.component';
import { AttributesComponent } from './attributes/attributes.component';
import { PipesComponent } from './pipes/pipes.component';
import { StringLengthPipe } from './common/stringlengthpipe';
import { ElementExistsPipe } from './common/elementexistpipe';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { AddEmployeeReactiveComponent } from './add-employee-reactive/add-employee-reactive.component';
import { ForbiddenAgeValidatorDirective } from './common/forbiddenAgeValidator';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    StructureComponent,
    AttributesComponent,
    PipesComponent,
    StringLengthPipe,
    ElementExistsPipe,
    AddEmployeeComponent,
    AddEmployeeReactiveComponent,
    ForbiddenAgeValidatorDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
