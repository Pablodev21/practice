import { Component, Input, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { PopUpComponent } from '../pop-up/pop-up.component';
import { DataShareService } from '../data-share.service';
import { Cliente } from '../objects/Cliente';
import { endPoint } from '../Constants/endPoint';
import { ServicioCache } from '../Cache/Servicio-Cache';
import { EditarComponentComponent } from '../editar-component/editar-component.component';
import { Router } from '@angular/router';



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
  public client!: Cliente;

  constructor(
    private http: HttpClient,
    public dialog: MatDialog,
    private dataShare: DataShareService,
    private Cache: ServicioCache,
    private router:Router,



  ){}
  
  ngOnInit(){

    // Llamada a los 8 primeros clientes default //

    this.http.get<Cliente[]>(endPoint.GET_8_CLIENTS)
    .subscribe(data=>{
      this.listaClientes = data;
    })

    this.listaClientes = this.Cache.get('listaClientes');
  }

  // Funcion que se activa desde el boton del popUp que guarda el id del Cliente que ocupa esa posicion //
  // selectedIndex(id:number){
  //     this.paramget= id;
  // }

  selectedIndex(id: any): Promise<void> {
    return new Promise<void>((resolve) => {
      this.paramget = id;
      resolve();
    });
  }

  // Método que espera a la recuperacion de datos //
  poopenPopupWait(): void {
    this.carga = true;
    
    setTimeout(() => {
      this.poopenPopup();
      this.carga = false;
    }, 2000);
   
  }

   // Método que espera a la recuperacion de datos //
   poopenPopupEditar(): void {
    this.carga = true;

    setTimeout(() => {
      this.abrirPopUpEditar();
      this.carga = false;
    }, 1000);
   
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

  abrirPopUpEditar(): void {
    
    // Tengo que mandar una info u otra en funcion a que estoy abriendo //
    var dialogRef = this.dialog.open(EditarComponentComponent, {
      width: '50%', height:'70%'
    });
    this.dataShare.setData(this.parametro);
   
  }

  async escogerCliente(){
    await this.selectedIndex(Cliente.id);

    for(let i =0;i< this.listaClientes.length;i++){
      if(this.paramget==this.listaClientes[i].id){
        this.Cache.set('client',this.listaClientes[i]);
        console.log(this.Cache.get('client'));
      }
    }

  }

  recargarInfo(){
    var resultado = window.confirm('¿Quieres recargar la información mostrada?');
    if(resultado==true){
      this.ngOnInit();
    }
  }
}

