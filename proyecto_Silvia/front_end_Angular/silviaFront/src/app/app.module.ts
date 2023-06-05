import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { PrincipalComponent } from './principal/principal.component';
import { HttpClientModule } from '@angular/common/http';
import { PopUpComponent } from './pop-up/pop-up.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { PopUpAntecedenteComponent } from './pop-up-antecedente/pop-up-antecedente.component';
import { PopUpAlergiaComponent } from './pop-up-alergia/pop-up-alergia.component';
import { PopUpTratamientoComponent } from './pop-up-tratamiento/pop-up-tratamiento.component';
import { PopUpCirugiaComponent } from './pop-up-cirugia/pop-up-cirugia.component';
import { PopUpObservacionComponent } from './pop-up-observacion/pop-up-observacion.component';
import { PopUpEvaluacionComponent } from './pop-up-evaluacion/pop-up-evaluacion.component';
import { RouterModule, Routes } from '@angular/router';
import { EditarComponentComponent } from './editar-component/editar-component.component';
import { VerificarComponent } from './verificar/verificar.component';
import { CrearClienteComponent } from './crear-cliente/crear-cliente.component';
import { GestionUsuarioComponent } from './gestion-usuario/gestion-usuario.component';


const appRoutes:Routes=[

  {path:'',component:LoginComponent},
  {path:'principal', component:PrincipalComponent},  
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PrincipalComponent,
    PopUpComponent,
    PopUpAntecedenteComponent,
    PopUpAlergiaComponent,
    PopUpTratamientoComponent,
    PopUpCirugiaComponent,
    PopUpObservacionComponent,
    PopUpEvaluacionComponent,
    EditarComponentComponent,
    VerificarComponent,
    CrearClienteComponent,
    GestionUsuarioComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatDialogModule,
    RouterModule.forRoot(appRoutes)
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
