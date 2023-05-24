import { Component } from '@angular/core';
import { ServicioCache } from '../Cache/Servicio-Cache';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../objects/Cliente';
import { endPoint } from '../Constants/endPoint';
import { MatDialogRef } from '@angular/material/dialog';


@Component({
  selector: 'app-editar-component',
  templateUrl: './editar-component.component.html',
  styleUrls: ['./editar-component.component.css']
})
export class EditarComponentComponent {
constructor(
  private Cache: ServicioCache,
  private http: HttpClient,
  public ventana: MatDialogRef<EditarComponentComponent>,

  ){}

  id!:number;
  nombre!:string;
  apellido!: string;
  telefono!:number;
  dni!:string;
  email!:string;
  lopd!:number;

  public carga: boolean=false;

  cliente!: Cliente;
  clienteModificado: Cliente = {
    id: 0,
    name: '',
    lastName: '',
    phone: 0,
    dni: '',
    email: '',
    lopd: 0
  };


  ngOnInit(){
    this.cliente=this.Cache.get('client');
    this.id= this.cliente.id;
    this.nombre = this.cliente.name;
    this.apellido = this.cliente.lastName;
    this.telefono = this.cliente.phone;
    this.dni = this.cliente.dni;
    this.email=this.cliente.email;
    this.lopd= this.cliente.lopd;

    this.clienteModificado.id=this.cliente.id;
    this.clienteModificado.name=this.cliente.name;
    this.clienteModificado.lastName= this.cliente.lastName;
    this.clienteModificado.phone=this.cliente.phone;
    this.clienteModificado.dni=this.cliente.dni;
    this.clienteModificado.email=this.cliente.email;
    this.clienteModificado.lopd=this.cliente.lopd;




    this.recogerCampos();
  }

  async modificarClient(){

    await this.recogerCampos();

    var resultado = window.confirm('¿Estás seguro/a de realizar los cambios?')
    if(resultado==true){

      this.http.put<Cliente>(endPoint.MOD_CLIENT+'/'+this.id, this.clienteModificado)
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

      const nombreElemento = document.getElementById('nombre') as HTMLInputElement;
      this.clienteModificado.name=nombreElemento.value;
    nombreElemento.addEventListener('change', () => {
      if(nombreElemento.value.length!=0){
        this.clienteModificado.name=nombreElemento.value;
      }else{
        this.clienteModificado.name=this.cliente.name;
      }  

    });

    const apellidosElemento = document.getElementById('apellidos') as HTMLInputElement;
    apellidosElemento.addEventListener('change', () => {
      if(apellidosElemento.value.length!=0){
        this.clienteModificado.lastName=apellidosElemento.value;
      }else{
        this.clienteModificado.lastName=this.cliente.lastName;
      }  
      
    });
    const telefonoElemento = document.getElementById('telefono') as HTMLInputElement;
    telefonoElemento.addEventListener('change', () => {

      if(dniElemento.value.length!=0){
        this.clienteModificado.phone = parseInt(telefonoElemento.value);
      }else{
        this.clienteModificado.phone=this.cliente.phone;
      }
   
      
    });



    const dniElemento = document.getElementById('dni') as HTMLInputElement;
    dniElemento.addEventListener('change', () => {

      if(dniElemento.value.length!=0){
        this.clienteModificado.dni = dniElemento.value;
      }else{
        this.clienteModificado.dni = this.cliente.dni;
      }
      
      
    });

    const emailElemento = document.getElementById('email') as HTMLInputElement;
    emailElemento.addEventListener('change', () => {
      if(emailElemento.value.length!=0){
        this.clienteModificado.email=emailElemento.value;
      }else{
        this.clienteModificado.email=this.cliente.email;
      }
      
      
    });

    const lopdElemento = document.getElementById('lopd') as HTMLInputElement;
    lopdElemento.addEventListener('change', () => {
      if(lopdElemento.value.length!=0){
        this.clienteModificado.lopd=parseInt(lopdElemento.value);
      }else{
        this.clienteModificado.lopd=this.cliente.lopd;
      }
      
    });
      resolve();
  });
}

  eliminarCliente() {
    var eliminar = window.confirm('¿Estás seguro/a de eliminar este PACIENTE? EL CAMBIO NO ES REVERSIBLE');
    if(eliminar==true){
      this.http.delete<Cliente>(endPoint.DEL_CLIENT+'/'+this.id)
      .subscribe(data => {
        window.confirm('PACIENTE ELIMINADO')
      });
      
    }else{
      window.alert('PACIENTE NO ELIMINADO');
    }

    this.ventana.close();
  }


  recargarListaClientes(){
    this.http.get<Cliente[]>(endPoint.GET_8_CLIENTS)
    .subscribe(data=>{
      this.Cache.set('listaClientes',data);
    })
  }


  cerrarVentana(){
    this.ventana.close();
  }
}

