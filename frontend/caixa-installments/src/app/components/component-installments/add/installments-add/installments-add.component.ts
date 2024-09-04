import {Component, Inject} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { Installment } from 'src/app/models/installments';
import { InstallmentService } from 'src/app/services/service-installments/service/installment.service';

@Component({
  selector: 'app-installments-add',
  templateUrl: './installments-add.component.html',
  styleUrls: ['./installments-add.component.scss'],

})
export class InstallmentsAddComponent {

  constructor(
    public dialogRef: MatDialogRef<InstallmentsAddComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Installment,
    private installmentService: InstallmentService
  ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }


  onFileSelected(event: Event): void {

    
    const input = event.target as HTMLInputElement;
    if (input.files?.length) {
      this.data.file = input.files[0];
    }
  }
 

  
}