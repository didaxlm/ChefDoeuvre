import { Injectable } from '@angular/core';
import * as jwt_decode from 'jwt-decode';
import {catchError, tap} from "rxjs/operators";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {FeedbackService} from "../feedback/feedback.service";
import {Router} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class JwtService
{
  idUser :number;

  constructor(private httpClient: HttpClient,
              private feedbackService: FeedbackService,
              private route: Router) { }

  /////////////////////////////////////////////////////////////////////////////////////////

  isLogged(): boolean
  {
    return Boolean(this.getToken());
  }

  isAdmin(): boolean
  {
    if (!this.isLogged()){
      return false;
    } else if (this.getRole() == 'ADMIN'){
      return true;
    } else return false;
  }

  getPseudo(): string
  {
    if (this.isLogged())
    {
      return this.userFromToken(this.getToken()).pseudo;
    }
    return undefined;
  }

  getRole(): string
  {
    if (this.isLogged())
    {
      return this.userFromToken(this.getToken()).role;
    }
    return undefined;
  }

  //////////////////////////////////////////////////////////////////////////////

  logout()
  {
    if (this.isLogged())
    {
      console.log(this.getPseudo());
      this.feedbackService.info.next(`${this.getPseudo()} disconnected`);
      this.clearToken();
      this.route.navigate(['/']);
    }
  }
  login(pseudo: string, password: string)
  {
    const user = {pseudo, motDePasse: password};

    return this.httpClient.post<{ access_token: string }>(`${environment.apiUrl}/users/sign-in`, user).pipe(
      tap(res => {
        this.setToken(res.access_token);
        this.feedbackService.info.next(`${pseudo} connected`);
        this.route.navigate(['/compte']);
      })
    );
  }

  // TODO add a register form
  register(pseudo: string, password: string, mail: string, codePostal: string, adresse: string, nom: string, prenom: string)
  {
    const user = {pseudo, motDePasse: password, mail, codePostal, adresse, nom, prenom};

    return this.httpClient.post<{ access_token: string }>(`${environment.apiUrl}/users/sign-up`, user).pipe(tap(res => {
      this.route.navigate(['/connexion']);
    }));
  }

  update(pseudo: string, password: string, mail: string, codePostal: string, adresse: string, nom: string, prenom: string)
  {
    const user = {pseudo, motDePasse: password, mail, codePostal, adresse, nom, prenom};

    return this.httpClient.put<{ access_token: string }>(`${environment.apiUrl}/users`, user).pipe(tap(_ => {
      this.login(pseudo, password);
    }));
  }


  getToken(): string
  {
    return sessionStorage.getItem('access_token');
  }

  setToken(token: string)
  {
    sessionStorage.setItem('access_token', token);
  }

  clearToken()
  {
    sessionStorage.removeItem('access_token');
    console.log("bizarre");
  }

  userFromToken(token: string): { role: string; pseudo: string; }
  {
    const decodedToken = jwt_decode(token);

    const name = decodedToken.sub;
    const roles = decodedToken.auth.map(authority => {
      return {label: authority.authority};
    });

    return { pseudo: name, role: roles[0]};
  }
  getUserId(){
    if (this.isLogged()){
    const token = sessionStorage.getItem('access_token');
    const decodedToken = jwt_decode(token);

    return decodedToken.id;
    }
  }

}
