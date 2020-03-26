import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DonObjetsComponent} from "./don-objets/don-objets.component";


const routes: Routes = [
  { path: 'don-objets', component: DonObjetsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
