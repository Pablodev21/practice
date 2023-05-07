import { Component, Input, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';


interface Client {
  id: number;
  name: string;
  lastName: string;  
  phone: string;
  dni: string;
  email:string;
  lopd: boolean;
}

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent {

public listaClientes: Client[] = [];


  constructor(
    private http: HttpClient
  ){}
  
  ngOnInit(){

    this.http.get<Client[]>('http://localhost:8080/fisioSilvia/client/get8Clients')
    .subscribe(data=>{

      this.listaClientes = data;


    })
  }
}
