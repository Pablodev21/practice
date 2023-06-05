import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { endPoint } from '../Constants/endPoint';
import { ServicioCache } from '../Cache/Servicio-Cache';
import { Cliente } from '../objects/Cliente';
import { Usuario } from '../objects/Usuario';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  confirmado: boolean = false;
  rolAdmin:boolean=false;
  public carga: boolean = false;
  nombre:string='';
  contrasena:string='';



  constructor(
    private router:Router,
    private http: HttpClient,
    private Cache: ServicioCache

    ){}


  ngOnInit(){

     // Llamada a los 8 primeros clientes default //

     this.http.get<Cliente[]>(endPoint.GET_8_CLIENTS)
     .subscribe(data=>{
       this.Cache.set('listaClientes',data);
     })



    const nombreElemento = document.getElementById('nombre') as HTMLInputElement;
    nombreElemento.addEventListener('blur', () => {
    this.nombre=nombreElemento.value;
    setTimeout(() => {

      this.carga = false;

    }, 500);
    });


    const contrasenaElemento = document.getElementById('contrasena') as HTMLInputElement;
    contrasenaElemento.addEventListener('blur', () => {
    this.contrasena=contrasenaElemento.value;
      this.carga=true;
      setTimeout(() => {
        // this.insertarRol();
        this.consultaLogin();
        this.carga = false;

      }, 2000);
    });
  }


  entrar(){
    if(this.confirmado){

      this.router.navigate(['principal'])
    }else{
      //Mostrar error //
    }
  }

  consultaLogin(){
    this.http.get<boolean>(endPoint.GET_LOGIN+'/'+this.nombre+'/'+this.contrasena)
    .subscribe(data=>{
      if(data){
        this.confirmado=true;
      }
    })
  }

  insertarRol(){
    this.http.get<Usuario>(endPoint.CheckRol_Usuario + this.nombre)
    .subscribe(data=>{
      if(data.rol=='admin'){
        this.rolAdmin=true;
        this.Cache.set('rol',this.rolAdmin);
        console.log(this.Cache.get('rol' + 'rol del usuario'));
      }
    })
  }
}

