import { Component } from '@angular/core';
import { ServicioCache } from '../Cache/Servicio-Cache';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../objects/Cliente';

@Component({
  selector: 'app-editar-component',
  templateUrl: './editar-component.component.html',
  styleUrls: ['./editar-component.component.css']
})
export class EditarComponentComponent {
constructor(
  private Cache: ServicioCache,
  private http: HttpClient,
  
  ){}
  nombre!:string;
  apellido!: string;
  dni!:string;
  email!:string;
  lopd!:number;


  cliente!: Cliente;
  


  ngOnInit(){
    this.cliente=this.Cache.get('client');
    this.nombre = this.cliente.name;
    this.apellido = this.cliente.lastName;
    this.dni = this.cliente.dni;
    this.email=this.cliente.email;
    this.lopd= this.cliente.lopd;

  }



  cerrar() {
    // Lógica para cerrar la pantalla
  }

  eliminarCliente() {
    // Lógica para eliminar el cliente
  }

  confirmarEdicion() {
    // Lógica para confirmar la edición del cliente
  }
}

