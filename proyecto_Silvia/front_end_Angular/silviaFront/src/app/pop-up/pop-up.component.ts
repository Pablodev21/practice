import { Component, Input } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { DataShareService } from '../data-share.service';

@Component({
  selector: 'app-pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.css']
})

export class PopUpComponent {
  
  datos: any;
  constructor(
    public dialogRef: MatDialogRef<PopUpComponent>,
    private dataShare: DataShareService,
    ){}

    ngOnInit(): void {
      this.dataShare.data$.subscribe(data => {
        this.datos = data;
      }); 
    }  
    
  closePopup(): void {

    this.datos=0;
    this.dialogRef.close();
  }

}
