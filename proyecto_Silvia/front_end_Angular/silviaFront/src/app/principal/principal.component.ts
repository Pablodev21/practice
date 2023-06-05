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
import { CrearClienteComponent } from '../crear-cliente/crear-cliente.component';



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
  public clienteNuevo!:Cliente;
  public filtroNombre:string="";
  public filtroDNI:string="";
  public filtroTelefono:number=0;
  public filtroRealizado:string="";
  public contador:number=0;
  public rolAdmin:boolean=false;

  constructor(
    private http: HttpClient,
    public dialog: MatDialog,
    private dataShare: DataShareService,
    private Cache: ServicioCache,
    private router:Router,



  ){}

  ngOnInit(){
    // console.log(this.Cache.get('rol' + 'rol usuario'));
    // Llamada a los 8 primeros clientes default //
    this.http.get<Cliente[]>(endPoint.GET_8_CLIENTS)
    .subscribe(data=>{
      this.listaClientes = data;
    })
    // this.comprobarRol();

    this.recogerCampos();

  }


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

  async escogerCliente(){
    await this.selectedIndex(Cliente.id);

    for(let i =0;i< this.listaClientes.length;i++){
      if(this.paramget==this.listaClientes[i].id){
        this.Cache.set('client',this.listaClientes[i]);

      }
    }

  }

  recargarInfo(){
    var resultado = window.confirm('¿Quieres recargar la información mostrada?');
    if(resultado==true){
      this.ngOnInit();
    }
  }

  abrirFiltros(){
    const campos = document.getElementById('cajaFiltro');
    const confirmarFiltros = document.getElementById('aplicarFiltros');

    if(campos !=null){
      if (campos.style.display === 'none') {
        campos.style.display = 'block';
      } else {
        campos.style.display = 'none';}
      }
    if(confirmarFiltros !=null){
      if (confirmarFiltros.style.display === 'none') {
        confirmarFiltros.style.display = 'block';
      } else {
        confirmarFiltros.style.display = 'none';}
      }


    }


    recogerCampos(): Promise<void> {
      return new Promise<void>((resolve) => {
        this.contador=0;
      const nombreElemento = document.getElementById('filtroNombre') as HTMLInputElement;
      nombreElemento.addEventListener('blur', () => {
        if(nombreElemento.value.length!=0){
          this.contador=1;
          this.filtroRealizado=endPoint.GET_CLIENTS_BY_NOMBRE+'/'+nombreElemento.value.toString();
          console.log(this.filtroRealizado);
        }else{

        }

      });

      const telefonoElemento = document.getElementById('filtroTelefono') as HTMLInputElement;
      telefonoElemento.addEventListener('blur', () => {
        if(telefonoElemento.value.length!=0){
          this.contador=1;
          this.filtroRealizado=endPoint.GET_CLIENTS_BY_PHONE+'/'+telefonoElemento.value.toString();
          console.log(this.filtroRealizado);
        }else{

        }

      });
      const dniElemento = document.getElementById('filtroDni') as HTMLInputElement;
      dniElemento.addEventListener('blur', () => {

        if(dniElemento.value.length!=0){
          this.contador=1;
          this.filtroRealizado=endPoint.GET_CLIENTS_BY_DNI+'/'+dniElemento.value.toString();
          console.log(this.filtroRealizado);
        }else{

        }


      });

        resolve();
    });
  }

    aplicarFiltros(){
      if(this.contador==1){
        this.contador=0;
        window.confirm('Selecciona un único filtro');
      }
        var confirmarFiltrado = window.confirm('¿Quieres aplicar el filtro seleccionado?');
        this.http.get<Cliente[]>(this.filtroRealizado)
      .subscribe(data=>{
        this.listaClientes.splice(0, this.listaClientes.length);
         this.listaClientes = data;

      })
    }

    abrirGestionUsuario(){
      this.router.navigate(['usuarios']);
    }

    comprobarRol(){
      const botonUsuarios = document.getElementById('botonUsuariosRol')  as HTMLInputElement;
      if(this.Cache.get('rol')){
        botonUsuarios.style.display = 'block';
      }
    }

}
