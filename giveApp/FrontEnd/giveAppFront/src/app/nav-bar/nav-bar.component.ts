import { Component} from '@angular/core';
import {JwtService} from '../partage/jwt/jwt.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent
{
  // utilisateurConnect: number;

  constructor(public jwt: JwtService) { }
}
