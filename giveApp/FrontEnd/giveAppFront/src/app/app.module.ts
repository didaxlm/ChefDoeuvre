import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './footer/footer.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { AccueilComponent } from './accueil/accueil.component';
import { RechercheComponent } from './recherche/recherche.component';
import { ConnexionComponent } from './connexion/connexion.component';
import {environment} from "../environments/environment";
import {JwtModule} from '@auth0/angular-jwt';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CompteComponent } from './connexion/compte/compte.component';
import { ArticleDetailsComponent } from './articles/article-details/article-details.component';
import { ArticlesComponent } from './articles/articles.component';
import { DonArticlesComponent } from './articles/don-articles/don-articles.component';
import { NotFoundComponent } from './not-found/not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavBarComponent,
    AccueilComponent,
    RechercheComponent,
    ConnexionComponent,
    CompteComponent,
    ArticleDetailsComponent,
    ArticlesComponent,
    DonArticlesComponent,
    NotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: function tokenGetter() {
          return localStorage.getItem('access_token');
        },
        whitelistedDomains: [environment.server],
        blacklistedRoutes: [`${environment.apiUrl}/sign-in`]
      }
    }),
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
