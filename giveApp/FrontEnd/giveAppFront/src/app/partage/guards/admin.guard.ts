import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import {JwtService} from '../jwt/jwt.service';

@Injectable()
export class AdminGuard implements CanActivate {

  constructor(private router: Router, private jwtService: JwtService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    if (!this.jwtService.isLogged()) {
      return false;
    } else if (this.jwtService.getRole() == 'ADMIN') {
      return true;
    }

    return false;
  }
}
