import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { DataShareService } from '../data-share.service';


@Component({
  selector: 'app-pop-up-window',
  templateUrl: './pop-up-window.component.html',
  styleUrls: ['./pop-up-window.component.css']
})
export class PopUpWindowComponent {
  datos: any;
  constructor(
    private http: HttpClient,
    public dialogRef: MatDialogRef<PopUpWindowComponent>,
    private dataShare: DataShareService,
    ){}


    closePopup(): void {

      this.datos=0;
      this.dialogRef.close();
    }
}
