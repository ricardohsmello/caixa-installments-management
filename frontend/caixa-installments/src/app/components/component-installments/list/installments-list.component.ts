import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { InstallmentService } from '../../../services/service-installments/service/installment.service';
import { Installment } from '../../../models/installments';
import { MatDialog } from '@angular/material/dialog';
import { InstallmentsAddComponent } from '../add/installments-add/installments-add.component';
// import { InstallmentDialogComponent } from './installments.dialog.component';

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
    private cdr: ChangeDetectorRef
    ) {
  }

  async ngOnInit() {
      this.installmentService.findAll().subscribe(data => {
      this.installments = data;
    });
  }

  deleteInstallment(id?: string) {
    this.installmentService.delete(id)
  }


  public openInstallmentsDialog() {
    const dialogRef = this.dialog.open(InstallmentsAddComponent, {
      data: {installment: this.installment},
    })

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.installmentService.save(result).subscribe(savedInstallment => {
          if (this.installments !== undefined) {
             this.installments.push(savedInstallment);
          }
         
        });
      }
    });
  }
}

 