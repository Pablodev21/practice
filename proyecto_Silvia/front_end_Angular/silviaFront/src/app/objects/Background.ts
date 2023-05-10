export class Background {
    id: number;
    idClient: number;
    description: string;
    date: string;
  
    constructor(id: number, idClient: number, description: string, date: string) {
      this.id = id;
      this.idClient = idClient;
      this.description = description;
      this.date = date;
    }
  }