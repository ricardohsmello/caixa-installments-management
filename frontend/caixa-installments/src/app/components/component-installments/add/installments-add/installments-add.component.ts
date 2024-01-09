import {Component, Inject} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

import { Installment } from 'src/app/models/installments';


@Component({
  selector: 'app-installments-add',
  templateUrl: './installments-add.component.html',
  styleUrls: ['./installments-add.component.scss'],

})
export class InstallmentsAddComponent {
  constructor(
    public dialogRef: MatDialogRef<InstallmentsAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Installment
   
  ) {
     
  }
 
  onNoClick(): void {
    this.dialogRef.close();
  }


}