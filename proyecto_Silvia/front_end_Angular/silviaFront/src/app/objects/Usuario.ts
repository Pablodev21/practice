export class Usuario {
    static id(id: any) {
      throw new Error('Method not implemented.');
    }
    id: number;
    login:String;
    password: string;
    rol: string;

    constructor(id: number,  login:String, password: string, rol: string) {
      this.id = id;
      this.login=login;
      this.password = password;
      this.rol = rol;
    }
  }
