import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllproductsComponent } from '../content/allproducts/allproducts.component';
import { ProductDetailsComponent } from '../content/product-details/product-details.component';
import { ProfileComponent } from '../content/profile/profile.component';
import { UserSupportComponent } from '../content/user-support/user-support.component';
import { LoginComponent } from '../modul/login/login.component';
import { PinInputComponent } from '../modul/pin-input/pin-input.component';
import { RegistrationComponent } from '../modul/registration/registration.component';
//import { ProfileInfoComponent } from '../profile/profile-info/profile-info.component';

import { HomeComponent } from './home/home.component';



const routes: Routes = [

  
  {path:'' , component:HomeComponent, children : [
    {path:"product/:id", component:ProductDetailsComponent},
    {path:"",component:AllproductsComponent},
    {path:"profile", component:ProfileComponent}
  ]},
  { path:'login', component:LoginComponent},
  { path:'registration', component:RegistrationComponent},
  { path:'pin', component:PinInputComponent},
  { path:'user-support', component:UserSupportComponent}
  
  // {path:"", loadChildren: () => import('../content/content.module').then(mod => mod.ContentModule)}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
