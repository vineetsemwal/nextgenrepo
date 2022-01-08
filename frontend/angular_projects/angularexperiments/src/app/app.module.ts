import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { TestComponent } from './test/test.component';
import { StructureComponent } from './structure/structure.component';
import { AttributesComponent } from './attributes/attributes.component';
import { PipesComponent } from './pipes/pipes.component';
import { CustomLengthPipe } from './common/customlengthpipe';
import { ElementExistsPipe } from './common/elementexistpipe';
import { AddEmployeeComponent } from './add-employee/add-employee.component';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    StructureComponent,
    AttributesComponent,
    PipesComponent,
    CustomLengthPipe,
    ElementExistsPipe,
    AddEmployeeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
