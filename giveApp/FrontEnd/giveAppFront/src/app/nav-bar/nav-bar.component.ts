import { Component} from '@angular/core';
import {JwtService} from '../partage/jwt/jwt.service';
import {UserServices} from '../partage/services/user.services';
import {UserModel} from '../partage/models/userModel';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {
  utilisateurConnect: number;
  userDetails: UserModel[];

  constructor(public jwt: JwtService,
              private userServices: UserServices) { }
}
