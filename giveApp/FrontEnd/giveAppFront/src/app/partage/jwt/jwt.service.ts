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

  constructor(private httpClient: HttpClient, private feedbackService: FeedbackService, private route: Router) { }

  /////////////////////////////////////////////////////////////////////////////////////////

  isLogged(): boolean
  {
    return Boolean(JwtService.getToken());
  }

  getPseudo(): string
  {
    if (this.isLogged())
    {
      return JwtService.userFromToken(JwtService.getToken()).pseudo;
    }
    return undefined;
  }

  getRole(): string
  {
    if (this.isLogged())
    {
      return JwtService.userFromToken(JwtService.getToken()).role;
    }
    return undefined;
  }

  //////////////////////////////////////////////////////////////////////////////

  login(pseudo: string, password: string)
  {
    const user = {pseudo, motDePasse: password};

    return this.httpClient.post<{ access_token: string }>(`${environment.apiUrl}/users/sign-in`, user).pipe(
      tap(res => {
        JwtService.setToken(res.access_token);
        this.feedbackService.info.next(`${pseudo} connected`);
        this.route.navigate(['/compte']);
      }),
      catchError(this.feedbackService.handleError<{ access_token: string }>('login'))
    );
  }

  // TODO add a register form
  register(pseudo: string, password: string)
  {
    const user = {name: pseudo, password: password};

    this.httpClient.post<{ access_token: string }>(`${environment.apiUrl}/sign-up`, user).pipe(tap(_ => {
      this.login(pseudo, password);
    }));
  }

  logout()
  {
    if (this.isLogged())
    {
      this.feedbackService.info.next(`${this.getPseudo()} disconnected`);
      JwtService.clearToken();
    }
  }

  private static getToken(): string
  {
    return sessionStorage.getItem('access_token');
  }

  private static setToken(token: string)
  {
    sessionStorage.setItem('access_token', token);
  }

  private static clearToken()
  {
    sessionStorage.removeItem('access_token');
  }

  private static userFromToken(token: string): { role: string; pseudo: string; }
  {
    const decodedToken = jwt_decode(token);

    const name = decodedToken.sub;
    const roles = decodedToken.auth.map(authority => {
      return {label: authority.authority};
    });

    return { pseudo: name, role: roles[0]};
  }

}
