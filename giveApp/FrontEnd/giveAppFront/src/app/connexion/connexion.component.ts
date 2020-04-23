import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {User} from "../partage/models/user";
import {JwtService} from "../partage/jwt/jwt.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit
{
  connexionForm: FormGroup;
  submitted: false;

  user: User = new User();

  constructor(private fb: FormBuilder, private auth: JwtService, private router: Router) { }

  ngOnInit(): void {
    this.connexionForm = this.fb.group({
      pseudo: "",
      password: ""
    });
  }

  redirection()
  {
  this.auth.login(this.connexionForm.get("pseudo").value, this.connexionForm.get("password").value)
    .subscribe(data =>console.log(data));
  }
}
