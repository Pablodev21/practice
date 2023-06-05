
 export class Cliente {
  static id(id: any) {
    throw new Error('Method not implemented.');
  }
  id: number;
  name: string;
  lastName: string;
  phone: number;
  dni: string;
  email: string;
  lopd: number;

  constructor(
    id: number,
    name: string,
    lastName: string,
    phone: number,
    dni: string,
    email: string,
    lopd: number
  ) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.phone = phone;
    this.dni = dni;
    this.email = email;
    this.lopd = lopd;
  }
}
