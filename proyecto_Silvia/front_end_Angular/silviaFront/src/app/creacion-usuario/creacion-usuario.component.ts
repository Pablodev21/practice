import { Component } from '@angular/core';
import { ServicioCache } from '../Cache/Servicio-Cache';
import { HttpClient } from '@angular/common/http';
import { MatDialogRef } from '@angular/material/dialog';
import { Usuario } from '../objects/Usuario';
import { endPoint } from '../Constants/endPoint';

@Component({
  selector: 'app-creacion-usuario',
  templateUrl: './creacion-usuario.component.html',
  styleUrls: ['./creacion-usuario.component.css']
})

export class CreacionUsuarioComponent {
  constructor(
    private Cache: ServicioCache,
    private http: HttpClient,
    public ventana: MatDialogRef<CreacionUsuarioComponent>,

    ){}
  id!:number;
  login!:string;
  contrasena!:string;
  rol!: string;

  public carga: boolean=false;

  usuario!: Usuario;
  usuarioNuevo: Usuario = {
    id: 0,
    login: "",
    password: '',
    rol: '',
  };




  ngOnInit(){
    this.http.get<Usuario[]>(endPoint.GET_8_CLIENTS)
    .subscribe(data=>{
      this.Cache.set('listaUsuarios',data);
    })

    this.recogerCampos();
  }

  async modificarUsuario(){

    await this.recogerCampos();

    var resultado = window.confirm('¿Estás seguro/a de realizar los cambios?')
    if(resultado==true){

      this.http.put<Usuario>(endPoint.MOD_Usuario+'/'+this.id, this.usuarioNuevo)
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

      const nombreElemento = document.getElementById('login') as HTMLInputElement;
      this.usuarioNuevo.login = nombreElemento.value;
    nombreElemento.addEventListener('change', () => {
      if(nombreElemento.value.length!=0){
        this.usuarioNuevo.login=nombreElemento.value;
      }else{
        this.usuarioNuevo.login=this.usuario.login;
      }

    });
    const contrasenaElemento = document.getElementById('contrasena') as HTMLInputElement;
    this.usuarioNuevo.login = nombreElemento.value;
    contrasenaElemento.addEventListener('change', () => {
    if(contrasenaElemento.value.length!=0){
      this.usuarioNuevo.password=contrasenaElemento.value;
    }else{
      this.usuarioNuevo.password=this.usuario.password;
    }

  });
    const rolElemento = document.getElementById('rol') as HTMLInputElement;
    rolElemento.addEventListener('change', () => {
      if(rolElemento.value.length!=0){
        this.usuarioNuevo.rol = rolElemento.value;
      }else{
        this.usuarioNuevo.rol=this.usuario.rol;
      }

    });

      resolve();
  });
}

  eliminarUsuario() {
    var eliminar = window.confirm('¿Estás seguro/a de eliminar este PACIENTE? EL CAMBIO NO ES REVERSIBLE');
    if(eliminar==true){
      this.http.delete<Usuario>(endPoint.DEL_CLIENT+'/'+this.id)
      .subscribe(data => {
        window.confirm('USUARIO ELIMINADO')
      });

    }else{
      window.alert('USUARIO NO ELIMINADO');
    }

    this.ventana.close();
  }


  recargarListaUsuarios(){
    this.http.get<Usuario[]>(endPoint.GET_8_CLIENTS)
    .subscribe(data=>{
      this.Cache.set('listaUsuarios',data);
    })
  }

  crearUsuario(){

    var respuesta = window.confirm('Quieres crear un  nuevo/a Usuario?');
      if(respuesta){

        this.http.post<Usuario>(endPoint.SAVE_Usuario, this.usuarioNuevo)
      .subscribe(data => {
        if(data.login == this.usuarioNuevo.login){
          window.confirm('Cliente Guardado');
        }else{
          window.confirm('No se ha podido guardar el/la paciente');
        }
      });
      }
  }
  cerrarVentana(){
    this.ventana.close();
  }
}


