import { Component, Input } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { DataShareService } from '../data-share.service';
import { Background } from '../objects/Background';
import { endPoint } from '../Constants/endPoint';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.css']
})

export class PopUpComponent {
  

  public listBackgrounds: Background[] = [];

  datos: any;
  constructor(
    private http: HttpClient,
    public dialogRef: MatDialogRef<PopUpComponent>,
    private dataShare: DataShareService,
    ){}

    ngOnInit(): void {
      this.dataShare.data$.subscribe(data => {
        this.datos = data;
      }); 


    //   this.http.get<Background[]>(endPoint.GET_BACKGROUNDS_IDCLIENT+this.datos)
    //   .subscribe((data: Background[])=>{
    //   this.listBackgrounds = data;
    // })


    }  

  closePopup(): void {

    this.datos=0;
    this.dialogRef.close();
  }

  changeRoute(){

  }

}
