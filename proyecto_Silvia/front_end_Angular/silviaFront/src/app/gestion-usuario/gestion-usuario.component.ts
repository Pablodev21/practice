import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DataShareService } from '../data-share.service';
import { ServicioCache } from '../Cache/Servicio-Cache';
import { Router } from '@angular/router';
import { Usuario } from '../objects/Usuario';
import { endPoint } from '../Constants/endPoint';
import { PopUpComponent } from '../pop-up/pop-up.component';
import { EditarComponentComponent } from '../editar-component/editar-component.component';
import { CrearClienteComponent } from '../crear-cliente/crear-cliente.component';

@Component({
  selector: 'app-gestion-usuario',
  templateUrl: './gestion-usuario.component.html',
  styleUrls: ['./gestion-usuario.component.css']
})
export class GestionUsuarioComponent {


  public listaUsuarios: Usuario[] = [];
  public carga:boolean=false;
  public parametro: number =0;
  public paramget:string="";

  constructor(
    private http: HttpClient,
    public dialog: MatDialog,
    private dataShare: DataShareService,
    private Cache: ServicioCache,
    private router:Router,



  ){}

  ngOnInit(){

    // Llamada a los 8 primeros clientes default //

    this.http.get<Usuario[]>(endPoint.GET_8_CLIENTS)
    .subscribe(data=>{
      this.listaUsuarios = data;
    })
  }

// Recargar el componente y su información //
  recargarInfo(){
    var resultado = window.confirm('¿Quieres recargar la información mostrada?');
    if(resultado==true){
      this.ngOnInit();
    }
  }

// Funcion que se activa desde el boton del popUp que guarda el login del Usuario que ocupa esa posicion //
  selectedIndex(login: any): Promise<void> {
    return new Promise<void>((resolve) => {
      this.paramget = login;
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

  // Método que espera a la recuperacion de datos //
   poopenPopupCrear(): void {
      this.carga = true;

      setTimeout(() => {
        this.abrirPopUpCrear();
        this.carga = false;
      }, 1000);

   }

  poopenPopupWait2(): void {
    this.carga = true;

    setTimeout(() => {
      this.poopenPopup();
      this.carga = false;
    }, 1000);

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

  abrirPopUpCrear(){
    // Tengo que mandar una info u otra en funcion a que estoy abriendo //
    var dialogRef = this.dialog.open(CrearClienteComponent, {
      width: '50%', height:'70%'
    });
  }
}
