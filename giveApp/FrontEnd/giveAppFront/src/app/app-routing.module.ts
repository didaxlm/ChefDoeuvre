import {Route, RouterModule} from '@angular/router';
import { DonObjetsComponent } from "./don-objets/don-objets.component";
import { AccueilComponent } from "./accueil/accueil.component";


const APP_ROUTE: Route[] = [
  { path: '', component: AccueilComponent },
  { path: 'don-objets', component: DonObjetsComponent }
];


export const AppRoutingModule = RouterModule.forRoot(APP_ROUTE);
