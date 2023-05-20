import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { endPoint } from '../Constants/endPoint';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  confirmado: boolean = false;
  public carga: boolean = false;
  nombre:string=''; 
  contrasena:string='';



  constructor(private router:Router,private http: HttpClient,){}


  ngOnInit(){
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
      console.log(data +' valor de data recuperada');
    })
  }


}

