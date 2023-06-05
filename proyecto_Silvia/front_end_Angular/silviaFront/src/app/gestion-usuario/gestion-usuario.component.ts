import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DataShareService } from '../data-share.service';
import { ServicioCache } from '../Cache/Servicio-Cache';
import { Router } from '@angular/router';
import { Usuario } from '../objects/Usuario';
import { endPoint } from '../Constants/endPoint';
import { EditarComponentComponent } from '../editar-component/editar-component.component';
import { CrearClienteComponent } from '../crear-cliente/crear-cliente.component';
import { CreacionUsuarioComponent } from '../creacion-usuario/creacion-usuario.component';
import { EditarUsuarioComponent } from '../editar-usuario/editar-usuario.component';

@Component({
  selector: 'app-gestion-usuario',
  templateUrl: './gestion-usuario.component.html',
  styleUrls: ['./gestion-usuario.component.css']
})
export class GestionUsuarioComponent {


  public listaUsuarios: Usuario[] = [];
  public carga:boolean=false;
  public parametro: number =0;
  public paramget:number=0;
  public usuario!: Usuario;

  constructor(
    private http: HttpClient,
    public dialog: MatDialog,
    private dataShare: DataShareService,
    private Cache: ServicioCache,
    private router:Router,

  ){}

  ngOnInit(){
    // Llamada a los 8 primeros usuarios default //
    this.http.get<Usuario[]>(endPoint.GET_Usuarios)
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

  selectedIndex(id: any): Promise<void> {
    return new Promise<void>((resolve) => {
      this.paramget = id;
      resolve();
    });
  }

  async escogerUsuario(){
    await this.selectedIndex(Usuario.id);

    for(let i =0;i< this.listaUsuarios.length;i++){
      if(this.paramget==this.listaUsuarios[i].id){
        this.Cache.set('usuario',this.listaUsuarios[i]);

      }
    }

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
    var dialogRef = this.dialog.open(EditarUsuarioComponent, {
      width: '50%', height:'70%'
    });
    this.dataShare.setData(this.parametro);

  }

  abrirPopUpEditar(): void {

    // Tengo que mandar una info u otra en funcion a que estoy abriendo //
    var dialogRef = this.dialog.open(EditarUsuarioComponent, {
      width: '50%', height:'70%'
    });
    this.dataShare.setData(this.parametro);

  }

  abrirPopUpCrear(){
    // Tengo que mandar una info u otra en funcion a que estoy abriendo //
    var dialogRef = this.dialog.open(CreacionUsuarioComponent, {
      width: '50%', height:'70%'
    });
  }

  // Método que espera a la recuperacion de datos //
  poopenPopupEditar(): void {
    this.carga = true;

    setTimeout(() => {
      this.abrirPopUpEditar();
      this.carga = false;
    }, 1000);

  }

  volverInicio(){

    this.router.navigate(['principal']);
  }
}
