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

    this.recogerCampos();
  }

  modificarClient(){

    // await this.recogerCampos();
    var resultado = window.confirm('¿Estás seguro/a de realizar los cambios?')
    if(resultado==true){

      this.http.put<Cliente>(endPoint.MOD_CLIENT+'/'+this.id, this.clienteModificado)
      .subscribe(data => {
      });
      window.confirm('CAMBIOS REALIZADOS CORRECTAMENTE');

    }else{
      window.alert('Cambios NO realizados');
     
    }
    
    this.recargarListaClientes();
    
    setTimeout(() => {
      this.ventana.close();
      this.carga = false;
    }, 2000);
  }


  recogerCampos(){
    this.clienteModificado.id = this.cliente.id;
    return new Promise<void>((resolve) => {
      
      const nombreElemento = document.getElementById('nombre') as HTMLInputElement;
    nombreElemento.addEventListener('blur', () => {
      // if(nombreElemento.value!=''){
      //   this.clienteModificado.name=nombreElemento.value;
      // }else{
      //   console.log('nombre vacio '+nombreElemento.value);
      // }  
    
        this.clienteModificado.name=nombreElemento.value;
      

    });

    const apellidosElemento = document.getElementById('apellidos') as HTMLInputElement;
    apellidosElemento.addEventListener('blur', () => {
      // if(apellidosElemento.value!=''){
      //   this.clienteModificado.lastName=apellidosElemento.value;
      // }else{
      //   console.log('apellidos vacio '+apellidosElemento.value);
      // }  
      
        this.clienteModificado.lastName=apellidosElemento.value;
     
      
      
    });
    const telefonoElemento = document.getElementById('telefono') as HTMLInputElement;
    telefonoElemento.addEventListener('blur', () => {

      // if(dniElemento.value!=''){
      //   this.clienteModificado.dni = dniElemento.value;
      // }else{
      //   console.log('dni vacio '+ dniElemento.value);
      // }
      this.clienteModificado.phone = parseInt(telefonoElemento.value);
      
    });



    const dniElemento = document.getElementById('dni') as HTMLInputElement;
    dniElemento.addEventListener('blur', () => {

      // if(dniElemento.value!=''){
      //   this.clienteModificado.dni = dniElemento.value;
      // }else{
      //   console.log('dni vacio '+ dniElemento.value);
      // }
      this.clienteModificado.dni = dniElemento.value;
      
    });

    const emailElemento = document.getElementById('email') as HTMLInputElement;
    emailElemento.addEventListener('blur', () => {
      // if(emailElemento.value!=''){
      //   this.clienteModificado.email=emailElemento.value;
      // }else{
      //   console.log('email vacio ' + emailElemento.value);
      // }
      this.clienteModificado.email=emailElemento.value;
      
    });

    const lopdElemento = document.getElementById('lopd') as HTMLInputElement;
    lopdElemento.addEventListener('blur', () => {
      // if(lopdElemento.value!=''){
      //   this.clienteModificado.lopd=parseInt(lopdElemento.value);
      // }else{
      //   console.log('lopd vacio '+ lopdElemento.value);
      // }
    
      this.clienteModificado.lopd=parseInt(lopdElemento.value);

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

    this.recargarListaClientes();
    setTimeout(() => {
      this.ventana.close();
      this.carga = false;
    }, 2000);
   
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

