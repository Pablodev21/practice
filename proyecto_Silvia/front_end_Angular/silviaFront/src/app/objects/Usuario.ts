export class Usuario {
    id: number;
    login:String;
    contrasena: string;
    rol: string;
  
    constructor(id: number,  login:String, contrasena: string, rol: string) {
      this.id = id;
      this.login=login;
      this.contrasena = contrasena;
      this.rol = rol;
    }
  }