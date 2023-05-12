import { Component, Input, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { PopUpComponent } from '../pop-up/pop-up.component';
import { DataShareService } from '../data-share.service';
import { Client } from '../objects/Client';
import { endPoint } from '../Constants/endPoint';
import { PopUpWindowComponent } from '../pop-up-window/pop-up-window.component';


@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent {

  public listaClientes: Client[] = [];
  public paramget: number=0;
  public paramgetEdit:number =0;
  public loader: boolean=false;

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

  // Método que espera a la recuperacion de datos //
  poopenPopupWait(): void {
    this.loader = true;
    
    setTimeout(() => {
      this.poopenPopup();
      this.loader = false;
    }, 2000);
   
  }

  poopenPopupWait2(): void {
    this.loader = true;
    
    setTimeout(() => {
      this.poopenPopup();
      this.loader = false;
    }, 2000);
   
  }
  
  // Funcion que abre el popUp en cada boton y le manda el id del cliente seleccionado al popUp //
  poopenPopup(): void {
    
    // Tengo que mandar una info u otra en funcion a que estoy abriendo //
    // Para saber si tienes que editar el nombre, el dni, el numero... //
    var dialogRef = this.dialog.open(PopUpWindowComponent, {
      width: '40%', height:'50%'
    });
    this.dataShare.setData(this.paramgetEdit);
   
  }
}

