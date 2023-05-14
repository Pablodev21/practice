export class Evaluacion {
    id: number;
    idClient: number;
    name:String;
    description: string;
    date: string;
  
    constructor(id: number, idClient: number, name:String, description: string, date: string) {
      this.id = id;
      this.idClient = idClient;
      this.name=name;
      this.description = description;
      this.date = date;
    }
  }