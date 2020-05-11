import { Component, OnInit } from '@angular/core';
import {JwtService} from "../../partage/jwt/jwt.service";

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit
{

  constructor(private auth : JwtService) { }

  ngOnInit(): void {}

  deconnexion() { this.auth.logout(); }
}
