import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServicioCache {
  private cache: { [clave: string]: any } = {};

  // Devuelve el valor almacenado en funcion a la clave que se le mande //
  get(clave: string): any {
    return this.cache[clave];
  }

  // Introduce un valor y lo almacena en funcion el valor clave //
  set(clave: string, valor: any): void {
    this.cache[clave] = valor;
  }

  // Verifica si la clave existe //
  has(clave: string): boolean {
    return clave in this.cache;
  }

  // Elimina el valor almacenado en funcion a la clave //
  remove(clave: string): void {
    delete this.cache[clave];
  }
  
  // Limpia toda la informacion //
  clear(): void {
    this.cache = {};
  }
}