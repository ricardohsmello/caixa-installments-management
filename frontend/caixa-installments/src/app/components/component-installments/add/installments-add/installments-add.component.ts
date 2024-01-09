import {Component, Inject} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import {FormGroup, FormControl, Validators, FormBuilder} from '@angular/forms';

import { Installment } from 'src/app/models/installments';
import { InstallmentService } from 'src/app/services/service-installments/service/installment.service';


@Component({
  selector: 'app-installments-add',
  templateUrl: './installments-add.component.html',
  styleUrls: ['./installments-add.component.scss'],

})
export class InstallmentsAddComponent {
  // amount = new FormControl('', [Validators.required]);

  constructor(
    public dialogRef: MatDialogRef<InstallmentsAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Installment
   
  ) {
     
  }
 
  onNoClick(): void {
    this.dialogRef.close();
  }


}