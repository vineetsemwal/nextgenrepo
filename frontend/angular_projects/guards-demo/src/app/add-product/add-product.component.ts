import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { IFormHolder } from '../iformholder';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit, IFormHolder {

  productNameCtrl:FormControl;
  formGroup:FormGroup
  constructor(builder:FormBuilder) {
   this.productNameCtrl=builder.control('');
   this.formGroup=builder.group({
     "productName":this.productNameCtrl
   })
   }
  getFormGroup(): FormGroup {
    return this.formGroup;
  }
 
  ngOnInit(): void {
  }

  onFormSubmit(){

  }

}
