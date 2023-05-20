import { Component, Input } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { DataShareService } from '../data-share.service';
import { HttpClient } from '@angular/common/http';
import { PopUpAntecedenteComponent } from '../pop-up-antecedente/pop-up-antecedente.component';
import { PopUpCirugiaComponent } from '../pop-up-cirugia/pop-up-cirugia.component';
import { PopUpAlergiaComponent } from '../pop-up-alergia/pop-up-alergia.component';
import { PopUpEvaluacionComponent } from '../pop-up-evaluacion/pop-up-evaluacion.component';
import { PopUpTratamientoComponent } from '../pop-up-tratamiento/pop-up-tratamiento.component';
import { PopUpObservacionComponent } from '../pop-up-observacion/pop-up-observacion.component';

@Component({
  selector: 'app-pop-up',
  templateUrl: './pop-up.component.html',
  styleUrls: ['./pop-up.component.css']
})

export class PopUpComponent {
  
  // public listaDatos: Datos[] = [];

  public carga: boolean=false;
  public parametro:number =0;
  public tipo:String ="";


  datos: any;
  constructor(
    private http: HttpClient,
    public dialogRef: MatDialogRef<PopUpComponent>,
    private dataShare: DataShareService,
    public dialog: MatDialog,
    ){}

    ngOnInit(): void {
      this.dataShare.data$.subscribe(data => {
        this.datos = data;
      }); 
    }  

  closePopup(): void {

    this.datos=0;
    this.dialogRef.close();
  }


  // Método que espera a la recuperacion de datos //
  esperaVentana(): void {
    this.carga = true;
    
    setTimeout(() => {
      this.abrirVentana(this.tipo);
      this.carga = false;
      this.parametro=0;
    }, 2000);
  }

  // Funcion que abre el popUp en cada boton y le manda el id del cliente seleccionado al popUp //
  abrirVentana(tipo:String): void {
    
    
    switch (tipo) {
      case "antecedente":
        this.parametro=1;
        var dialogRef = this.dialog.open(PopUpAntecedenteComponent, {
          width: '50%', height:'70%'
        });
        this.dataShare.setData(this.parametro);
        break;

      case "alergia":
        this.parametro=2;
        var dialogRef = this.dialog.open(PopUpAlergiaComponent, {
          width: '50%', height:'70%'
        });
        this.dataShare.setData(this.parametro);
        break;

      case "cirugia":
        this.parametro=3;
        var dialogRef = this.dialog.open(PopUpCirugiaComponent, {
          width: '50%', height:'70%'
        });
        this.dataShare.setData(this.parametro);
        break;

      case "evaluacion":
        this.parametro=4;
        var dialogRef = this.dialog.open(PopUpEvaluacionComponent, {
          width: '50%', height:'70%'
        });
        this.dataShare.setData(this.parametro);
        break;

      case "tratamiento":
        this.parametro=5;
        var dialogRef = this.dialog.open(PopUpTratamientoComponent, {
          width: '50%', height:'70%'
        });
        this.dataShare.setData(this.parametro);
        break;

      case "observacion":
        this.parametro=6;
        var dialogRef = this.dialog.open(PopUpObservacionComponent, {
          width: '50%', height:'70%'
        });
        this.dataShare.setData(this.parametro);
        break;
    }
  }  
}
