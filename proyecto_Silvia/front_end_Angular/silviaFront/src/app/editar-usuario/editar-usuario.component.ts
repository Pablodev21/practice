import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ServicioCache } from '../Cache/Servicio-Cache';
import { DataShareService } from '../data-share.service';
import { Router } from '@angular/router';
import { Usuario } from '../objects/Usuario';
import { endPoint } from '../Constants/endPoint';

@Component({
  selector: 'app-editar-usuario',
  templateUrl: './editar-usuario.component.html',
  styleUrls: ['./editar-usuario.component.css']
})
export class EditarUsuarioComponent {


  constructor(
    private http: HttpClient,
    public dialog: MatDialog,
    private dataShare: DataShareService,
    private Cache: ServicioCache,
    private router:Router,
    public ventana: MatDialogRef<EditarUsuarioComponent>,
  ){}


  id!:number;
  login!:String;
  contrasena!: String;
  rol!:String;

  public carga: boolean=false;



  usuario!: Usuario;
  usuarioModificado: Usuario = {
    id: 0,
    login: '',
    password: '',
    rol: '',

  };


  ngOnInit(){
    this.usuario=this.Cache.get('usuario');
    this.id= this.usuario.id;
    console.log(this.usuario.id +'id del usuario');
    this.login = this.usuario.login;
    this.contrasena = this.usuario.password;
    this.rol = this.usuario.rol;

    this.usuarioModificado.login=this.usuario.login;
    this.usuarioModificado.id=this.usuario.id;
    this.usuarioModificado.password= this.usuario.password;
    this.usuarioModificado.rol=this.usuario.rol;

    this.recogerCampos();

  }

  async modificarUsuario(){

    await this.recogerCampos();

    var resultado = window.confirm('¿Estás seguro/a de realizar los cambios?')
    if(resultado==true){

      this.http.put<Usuario>(endPoint.MOD_Usuario+'/'+this.id, this.usuarioModificado)
      .subscribe(data => {
      });
      window.confirm('CAMBIOS REALIZADOS CORRECTAMENTE');
    }else{
      window.alert('Cambios NO realizados');
    }
    this.ventana.close();
  }

  recogerCampos(): Promise<void> {
    return new Promise<void>((resolve) => {

      const loginElemento = document.getElementById('login') as HTMLInputElement;
      this.usuarioModificado.login=loginElemento.value;
      loginElemento.addEventListener('change', () => {
      if(loginElemento.value.length!=0){
        this.usuarioModificado.login=loginElemento.value;
      }else{
        this.usuarioModificado.login=this.usuario.login;
      }

    });

    const contrasenaElemento = document.getElementById('contrasena') as HTMLInputElement;
    contrasenaElemento.addEventListener('change', () => {
      if(contrasenaElemento.value.length!=0){
        this.usuarioModificado.password=contrasenaElemento.value;
      }else{
        this.usuarioModificado.password=this.usuario.password;
      }

    });
    const rolElemento = document.getElementById('rol') as HTMLInputElement;
    rolElemento.addEventListener('change', () => {

      if(rolElemento.value.length!=0){
        this.usuarioModificado.rol = rolElemento.value;
      }else{
        this.usuarioModificado.rol=this.usuario.rol;
      }
    });

      resolve();
  });
}

  eliminarUsuario() {
    var eliminar = window.confirm('¿Estás seguro/a de eliminar este USUARIO? EL CAMBIO NO ES REVERSIBLE');
    if(eliminar==true){
      this.http.delete<Usuario>(endPoint.DEL_Usuario+'/'+this.id)
      .subscribe(data => {
        window.confirm('USUARIO ELIMINADO')
      });

    }else{
      window.alert('USUARIO NO ELIMINADO');
    }

    this.ventana.close();
  }


  recargarListaClientes(){
    this.http.get<Usuario[]>(endPoint.GET_8_CLIENTS)
    .subscribe(data=>{
      this.Cache.set('listaUsuarios',data);
    })
  }


  cerrarVentana(){
    this.ventana.close();
  }

}
