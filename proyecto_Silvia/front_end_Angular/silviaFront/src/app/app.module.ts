import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { PrincipalComponent } from './principal/principal.component';
import { IndivDataComponent } from './indiv-data/indiv-data.component';
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
import { HomeComponentComponent } from './home-component/home-component.component';
import { EditarComponentComponent } from './editar-component/editar-component.component';
import { VerificarComponentComponent } from './verificar-component/verificar-component.component';
import { VerificarComponent } from './verificar/verificar.component';


const appRoutes:Routes=[

  {path:'',component:LoginComponent},
  {path:'home', component:HomeComponentComponent},
  {path:'principal', component:PrincipalComponent},
  

]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PrincipalComponent,
    IndivDataComponent,
    PopUpComponent,
    PopUpAntecedenteComponent,
    PopUpAlergiaComponent,
    PopUpTratamientoComponent,
    PopUpCirugiaComponent,
    PopUpObservacionComponent,
    PopUpEvaluacionComponent,
    HomeComponentComponent,
    EditarComponentComponent,
    VerificarComponentComponent,
    VerificarComponent,

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
