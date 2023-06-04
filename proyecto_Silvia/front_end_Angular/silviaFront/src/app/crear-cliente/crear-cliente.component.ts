import { Component } from '@angular/core';
import { ServicioCache } from '../Cache/Servicio-Cache';
import { HttpClient } from '@angular/common/http';
import { MatDialogRef } from '@angular/material/dialog';
import { EditarComponentComponent } from '../editar-component/editar-component.component';
import { Cliente } from '../objects/Cliente';
import { endPoint } from '../Constants/endPoint';

@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.css']
})
export class CrearClienteComponent {

  id!:number;
  nombre!:string;
  apellido!: string;
  telefono!:number;
  dni!:string;
  email!:string;
  lopd!:number;

  clienteNuevo: Cliente = {
    id: 0,
    name: '',
    lastName: '',
    phone: 0,
    dni: '',
    email: '',
    lopd: 0
  };

  public carga: boolean=false;

  constructor(
    private Cache: ServicioCache,
    private http: HttpClient,
    public ventana: MatDialogRef<EditarComponentComponent>,
    ){}

    ngOnInit(){

      this.recogerCampos();
    }

    crearNuevoPaciente(){

      var respuesta = window.confirm('Quieres crear un este/a nuevo/a paciente?');
        if(respuesta){
          console.log(this.clienteNuevo.name + 'nombre')
          this.http.post<Cliente>(endPoint.SAVE_CLIENT, this.clienteNuevo)
        .subscribe(data => {
          if(data.name == this.clienteNuevo.name){
            window.confirm('Cliente Guardado');
          }else{
            window.confirm('No se ha podido guardar el/la paciente');
          }
        });
        }    
    }

    recogerCampos(): Promise<void> {
      return new Promise<void>((resolve) => {
  
        const nombreElemento = document.getElementById('nombre') as HTMLInputElement;
        
      nombreElemento.addEventListener('change', () => {
        if(nombreElemento.value.length!=0){
          this.clienteNuevo.name=nombreElemento.value;
        }else{
          this.clienteNuevo.name="default";
        }  
  
      });
  
      const apellidosElemento = document.getElementById('apellidos') as HTMLInputElement;
      apellidosElemento.addEventListener('change', () => {
        if(apellidosElemento.value.length!=0){
          this.clienteNuevo.lastName=apellidosElemento.value;
        }else{
          this.clienteNuevo.lastName="default";
        }  
        
      });
      const telefonoElemento = document.getElementById('telefono') as HTMLInputElement;
      telefonoElemento.addEventListener('change', () => {
  
        if(telefonoElemento.value.length!=0){
          this.clienteNuevo.phone = parseInt(telefonoElemento.value);
        }else{
          this.clienteNuevo.phone=999999999;
        }
     
        
      });
  
  
  
      const dniElemento = document.getElementById('dni') as HTMLInputElement;
      dniElemento.addEventListener('change', () => {
  
        if(dniElemento.value.length!=0){
          this.clienteNuevo.dni = dniElemento.value;
        }else{
          this.clienteNuevo.dni = "11111111H";
        }
        
        
      });
  
      const emailElemento = document.getElementById('email') as HTMLInputElement;
      emailElemento.addEventListener('change', () => {
        if(emailElemento.value.length!=0){
          this.clienteNuevo.email=emailElemento.value;
        }else{
          this.clienteNuevo.email="default@gmail.com";
        }
        
        
      });
  
      const lopdElemento = document.getElementById('lopd') as HTMLInputElement;
      lopdElemento.addEventListener('change', () => {
        if(lopdElemento.value.length!=0){
          this.clienteNuevo.lopd=parseInt(lopdElemento.value);
        }else{
          this.clienteNuevo.lopd=0;
        }
        
      });
        resolve();
    });
  }
  

  cerrarVentana(){
    this.ventana.close();
  }
}
