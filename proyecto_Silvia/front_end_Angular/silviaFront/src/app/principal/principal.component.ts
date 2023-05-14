import { Component, Input, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { PopUpComponent } from '../pop-up/pop-up.component';
import { DataShareService } from '../data-share.service';
import { Cliente } from '../objects/Cliente';
import { endPoint } from '../Constants/endPoint';



@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent {

  public listaClientes: Cliente[] = [];
  public paramget: number=0;
  public parametro:number =0;
  public carga: boolean=false;

  constructor(
    private http: HttpClient,
    public dialog: MatDialog,
    private dataShare: DataShareService


  ){}
  
  ngOnInit(){

    // Llamada a los 8 primeros clientes default //

    this.http.get<Cliente[]>(endPoint.GET_8_CLIENTS)
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
    this.carga = true;
    
    setTimeout(() => {
      this.poopenPopup();
      this.carga = false;
    }, 2000);
   
  }

  poopenPopupWait2(): void {
    this.carga = true;
    
    setTimeout(() => {
      this.poopenPopup();
      this.carga = false;
    }, 2000);
   
  }
  
  // Funcion que abre el popUp en cada boton y le manda el id del cliente seleccionado al popUp //
  poopenPopup(): void {
    
    // Tengo que mandar una info u otra en funcion a que estoy abriendo //
    // Para saber si tienes que editar el nombre, el dni, el numero... //
    var dialogRef = this.dialog.open(PopUpComponent, {
      width: '50%', height:'70%'
    });
    this.dataShare.setData(this.parametro);
   
  }
}

