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
  usuarioModificado: Usuario = {
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

      const nombreElemento = document.getElementById('login') as HTMLInputElement;
      this.usuarioModificado.login = nombreElemento.value;
    nombreElemento.addEventListener('change', () => {
      if(nombreElemento.value.length!=0){
        this.usuarioModificado.login=nombreElemento.value;
      }else{
        this.usuarioModificado.login=this.usuario.login;
      }

    });
    const contrasenaElemento = document.getElementById('contrasena') as HTMLInputElement;
    this.usuarioModificado.login = nombreElemento.value;
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


  cerrarVentana(){
    this.ventana.close();
  }
}


