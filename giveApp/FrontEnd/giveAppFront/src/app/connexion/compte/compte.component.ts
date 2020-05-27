import { Component, OnInit } from '@angular/core';
import {JwtService} from "../../partage/jwt/jwt.service";
import {UserModel} from "../../partage/models/userModel";
import {UserServices} from "../../partage/services/user.services";
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit
{
  userDetails : UserModel;

  constructor(public jwt: JwtService,
              private route: ActivatedRoute,
              public userServices: UserServices) { }

  ngOnInit() {
    this.recupererUtilisateur();
  }
  recupererUtilisateur(){
    const id = this.jwt.getUserId();
    id && this.userServices.getUnUser(id).subscribe( user => this.userDetails = user);
  }

  // updateUser()
  // {
  //   console.log(this.formulaireDuUser)
  //   this.jwt.update(
  //     this.formulaireDuUser.get("pseudo").value,
  //     this.formulaireDuUser.get("motDePasse").value,
  //     this.formulaireDuUser.get("mail").value,
  //     this.formulaireDuUser.get("codePostal").value,
  //     this.formulaireDuUser.get("adresse").value,
  //     this.formulaireDuUser.get("nom").value,
  //     this.formulaireDuUser.get("prenom").value)
  //     .subscribe(
  //       data => console.log(data),
  //       () => this.formulaireDuUser.setErrors({invalidLogin: true})
  //     );
  // }
}
