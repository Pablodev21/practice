
 export class Client {
  id: number;
  name: string;
  lastName: string;
  phone: string;
  dni: string;
  email: string;
  lopd: boolean;

  constructor(
    id: number,
    name: string,
    lastName: string,
    phone: string,
    dni: string,
    email: string,
    lopd: boolean
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
  