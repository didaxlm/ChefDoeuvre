import {Route, RouterModule} from '@angular/router';
import { DonObjetsComponent } from "./don-objets/don-objets.component";
import { AccueilComponent } from "./accueil/accueil.component";
import {ConnexionComponent} from "./connexion/connexion.component";
import {UserGuard} from "./partage/guards/user.guard";
import {AdminGuard} from "./partage/guards/admin.guard";
import {CompteComponent} from "./compte/compte.component";


const APP_ROUTE: Route[] = [
  { path: '', component: AccueilComponent },
  { path: 'don-objets', component: DonObjetsComponent },
  { path: 'connexion', component: ConnexionComponent},
  { path: 'compte', component: CompteComponent },
  //{ path: '', redirectTo: '/post', pathMatch: 'full'},
  { path: 'post', component: ConnexionComponent, canActivate: [UserGuard]},
  { path: 'admin', component: ConnexionComponent, canActivate: [AdminGuard]}
];


export const AppRoutingModule = RouterModule.forRoot(APP_ROUTE);
