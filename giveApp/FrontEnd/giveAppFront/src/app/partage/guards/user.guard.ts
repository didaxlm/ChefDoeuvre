import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Route, Router} from '@angular/router';
import {JwtService} from "../jwt/jwt.service";

@Injectable()
export class UserGuard implements CanActivate
{
  constructor(private router: Router, private jwtService: JwtService) {
  }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
  {
    return true;
  }

}
