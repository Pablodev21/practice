import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

// Clase service que utilizo para comunicar la ventana principal con los popUp //
export class DataShareService {

  private dataSubject = new BehaviorSubject<any>(null);
  public data$ = this.dataSubject.asObservable();
  constructor() {
  
   }

   // Método para enviar los datos //
   setData(data: any) {
    this.dataSubject.next(data);
  }
}
