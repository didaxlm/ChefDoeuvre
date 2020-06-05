import { Component, OnInit } from '@angular/core';
import {JwtService} from "../../partage/jwt/jwt.service";
import {UserModel} from "../../partage/models/userModel";
import {UserServices} from "../../partage/services/user.services";
import {ConnexionComponent} from "../connexion.component";
import {FormControl} from "@angular/forms";



@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent extends ConnexionComponent implements OnInit
{
  userDetails : UserModel;

  constructor(public jwt: JwtService,
              public userServices: UserServices) {
    super (jwt);
  }

  ngOnInit() {
    this.recupererUtilisateur();
  }
  recupererUtilisateur(){
    const id = this.jwt.getUserId();
    id && this.userServices.getUnUser(id).subscribe( user => {
      this.userDetails = user;
      this.formulaireDinscription.controls.id.setValue(this.userDetails.id);
      this.formulaireDinscription.controls.dateInscription.setValue(this.userDetails.dateInscription);
      this.formulaireDinscription.controls.nom.setValue(this.userDetails.nom);
      this.formulaireDinscription.controls.prenom.setValue( this.userDetails.prenom);
      this.formulaireDinscription.controls.pseudo.setValue( this.userDetails.pseudo);
      this.formulaireDinscription.controls.adresse.setValue( this.userDetails.adresse);
      this.formulaireDinscription.controls.codePostal.setValue( this.userDetails.codePostal);
      this.formulaireDinscription.controls.mail.setValue( this.userDetails.mail);
      this.formulaireDinscription.controls.motDePasse.setValue( this.userDetails.motDePasse);
    });
  }

  updateUser()
  {
    console.log(this.formulaireDinscription);
    this.formulaireDinscription.markAllAsTouched();
    this.jwt.update(
      this.formulaireDinscription.get("id").value,
      this.formulaireDinscription.get("dateInscription").value,
      this.formulaireDinscription.get("pseudo").value,
      this.formulaireDinscription.get("motDePasse").value,
      this.formulaireDinscription.get("mail").value,
      this.formulaireDinscription.get("codePostal").value,
      this.formulaireDinscription.get("adresse").value,
      this.formulaireDinscription.get("nom").value,
      this.formulaireDinscription.get("prenom").value)
      .subscribe(
        data => console.log(data),
        () => this.formulaireDinscription.setErrors({invalidLogin: true})
      );
    this.jwt.logout();
  }
}
