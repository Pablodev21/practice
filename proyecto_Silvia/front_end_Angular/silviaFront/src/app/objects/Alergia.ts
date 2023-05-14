export class Alergia {
    id: number;
    idClient: number;
    name:String;
    description: string;
 
  
    constructor(id: number, idClient: number, name:String, description: string) {
      this.id = id;
      this.idClient = idClient;
      this.name=name;
      this.description = description;
    }
  }