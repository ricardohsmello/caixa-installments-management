import { Component, OnInit } from '@angular/core';
import { InstallmentService } from '../../../services/service-installments/service/installment.service';
import { Installment } from '../../../models/installments';
import { InstallmentsAddComponent } from '../add/installments-add/installments-add.component';

import {
  MatDialog
} from '@angular/material/dialog';
import { ComponentDialogConfirmComponent } from '../../component-dialog-confirm/component-dialog-confirm.component';

@Component({
  selector: 'app-installments',
  templateUrl: './installments-list.component.html',
  styleUrls: ['./installments-list.component.scss']
})
export class InstallmentsComponent  {

  installments?: Installment[] = [];
  installment?: Installment

  constructor(
    private installmentService: InstallmentService,
    public dialog: MatDialog,
    ) {
  }


  async ngOnInit() {
      this.installmentService.findAll().subscribe(data => {
      this.installments = data;
    });
  }
 
  public openNewInstallmentDialog() {
    const dialogRef = this.dialog.open(InstallmentsAddComponent, {
      data: {installment: this.installment},
    })

    dialogRef.afterClosed().subscribe(result => {
      if (result) {


        const formData = new FormData();
        // formData.append('installmentRequest', new Blob([JSON.stringify(result)], {
        //   type: "application/json"
        // }));
        formData.append('file', result.file, result.file.name);



        this.installmentService.save(formData).subscribe(savedInstallment => {
          if (this.installments !== undefined) {
             this.installments.push(savedInstallment);
          }
         
        });
      }
    });
  }

  openDialog(installmentId?: string) {
    const dialogRef = this.dialog.open(ComponentDialogConfirmComponent, {
    })

    dialogRef.afterClosed().subscribe(result => {
      
      if (result) {
        this.installmentService.delete(installmentId).subscribe(() => {
          // Remove the deleted item from the installments array
          this.installments = this.installments?.filter(inst => inst.id !== installmentId);
        });
      }
    });
  }
 
  
 

}
