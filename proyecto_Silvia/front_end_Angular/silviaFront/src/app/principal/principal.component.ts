import { Component, Input, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { PopUpComponent } from '../pop-up/pop-up.component';
import { DataShareService } from '../data-share.service';
import { Client } from '../objects/Client';
import { endPoint } from '../Constants/endPoint';


@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent {

  public listaClientes: Client[] = [];
  public paramget: number=0;


  constructor(
    private http: HttpClient,
    public dialog: MatDialog,
    private dataShare: DataShareService


  ){}
  
  ngOnInit(){

    // Llamada a los 8 primeros clientes default //

    this.http.get<Client[]>(endPoint.GET_8_CLIENTS)
    .subscribe(data=>{
      this.listaClientes = data;
    })
  }

  // Funcion que se activa desde el boton del popUp que guarda el id del Cliente que ocupa esa posicion //
  selectedIndex(id:number){
      this.paramget= id;
    
  }

  poopenPopupWait(): void {
    
    setTimeout(() => {
      this.poopenPopup();
    }, 2000);
   
  }
  
  // Funcion que abre el popUp en cada boton y le manda el id del cliente seleccionado al popUp //
  poopenPopup(): void {
    
    var dialogRef = this.dialog.open(PopUpComponent, {
      width: '80%', height:'60%'
    });
    this.dataShare.setData(this.paramget);
   
  }
}

