import {Route, RouterModule} from '@angular/router';
import { DonArticlesComponent } from './articles/don-articles/don-articles.component';
import { AccueilComponent } from './accueil/accueil.component';
import {ConnexionComponent} from './connexion/connexion.component';
import {AdminGuard} from './partage/guards/admin.guard';
import {CompteComponent} from './connexion/compte/compte.component';
import {ArticleDetailsComponent} from './articles/article-details/article-details.component';
import {ArticlesComponent} from './articles/articles.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {RechercheComponent} from './recherche/recherche.component';

const APP_ROUTE: Route[] = [
  { path: '', component: AccueilComponent },
  { path: '', component: RechercheComponent },
  { path: 'articles/categorie/:id', component: ArticlesComponent },
  { path: 'articles/:id', component: ArticleDetailsComponent },
  { path: 'don-articles', component: DonArticlesComponent },
  { path: 'connexion', component: ConnexionComponent},
  { path: 'compte', component: CompteComponent },
  { path: 'admin', component: ConnexionComponent, canActivate: [AdminGuard]},
  { path: '**', component: NotFoundComponent }
];


export const AppRoutingModule = RouterModule.forRoot(APP_ROUTE);
