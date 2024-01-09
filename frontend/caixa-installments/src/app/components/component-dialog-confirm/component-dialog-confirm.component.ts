import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-component-dialog-confirm',
  templateUrl: './component-dialog-confirm.component.html',
  styleUrls: ['./component-dialog-confirm.component.scss']
})
export class ComponentDialogConfirmComponent {

  constructor(
    public dialogRef: MatDialogRef<ComponentDialogConfirmComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Boolean
  ) {
     
  }

  onOkClick(): void {
    this.dialogRef.close('Ok');
  }
 
  onNoClick(): void {
    this.dialogRef.close();
  }


}
