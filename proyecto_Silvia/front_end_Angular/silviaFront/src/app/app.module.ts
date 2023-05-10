import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { PrincipalComponent } from './principal/principal.component';
import { IndivDataComponent } from './indiv-data/indiv-data.component';
import { SideMenuComponent } from './side-menu/side-menu.component';
import { HttpClientModule } from '@angular/common/http';
import { PopUpComponent } from './pop-up/pop-up.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { PopUpBackgroundComponent } from './pop-up-background/pop-up-background.component'


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PrincipalComponent,
    IndivDataComponent,
    SideMenuComponent,
    PopUpComponent,
    PopUpBackgroundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatDialogModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
