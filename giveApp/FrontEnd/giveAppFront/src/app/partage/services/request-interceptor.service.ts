import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {JwtService} from "../jwt/jwt.service";

@Injectable({
  providedIn: 'root'
})
export class RequestInterceptorService implements HttpInterceptor
{
  constructor(private jwtService: JwtService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.jwtService.getToken();

    let newHeaders = req.headers;

    if (token && this.jwtService.isLogged()) {
      newHeaders = newHeaders.append('Authorization', `Bearer ${token}`);
    }
    const authRequest = req.clone({headers: newHeaders});
    return next.handle(authRequest);
  }
}
