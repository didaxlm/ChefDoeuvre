import {Component} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {JwtService} from '../partage/jwt/jwt.service';
import {IdentificationValidation} from './identification.validation';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})

export class ConnexionComponent {

  constructor(private auth: JwtService) { }

  get identifiant() {
    return this.formulaireDeConnexion.get('identifiant');
  }
  get password() {
    return this.formulaireDeConnexion.get('password');
  }

  get nom() {
    return this.formulaireDinscription.get('nom');
  }
  get prenom() {
    return this.formulaireDinscription.get('prenom');
  }
  get pseudo() {
    return this.formulaireDinscription.get('pseudo');
  }
  get adresse() {
    return this.formulaireDinscription.get('adresse');
  }
  get codePostal() {
    return this.formulaireDinscription.get('codePostal');
  }
  get mail() {
    return this.formulaireDinscription.get('mail');
  }
  get motDePasse() {
    return this.formulaireDinscription.get('motDePasse');
  }

  formulaireDeConnexion = new FormGroup({
    identifiant: new FormControl('', [
      Validators.required,
      Validators.minLength(3),
      IdentificationValidation.nePeutContenirEspace
    ]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(6), ])
  });

// ######################################################################################

  formulaireDinscription = new FormGroup({
    id: new FormControl(),
    dateInscription: new FormControl(),
    nom: new FormControl('', [
      Validators.required,
      Validators.minLength(2)
    ]),
    prenom: new FormControl('', [
      Validators.required,
      Validators.minLength(2)
    ]),
    pseudo: new FormControl('', [
      Validators.required,
      Validators.minLength(2),
      // IdentificationValidation.doitEtreUnique
    ]),
    adresse: new FormControl('', [
      Validators.required,
      Validators.minLength(2)
    ]),
    codePostal: new FormControl('', [
      Validators.required,
      Validators.minLength(2),
      Validators.maxLength(5),
      IdentificationValidation.nePeutContenirEspace
    ]),
    mail: new FormControl('', [
      Validators.required,
      Validators.minLength(2),
      IdentificationValidation.nePeutContenirEspace
    ]),
    motDePasse: new FormControl('', [
      Validators.required,
      Validators.minLength(6)
    ]),
  });
  signIn() {
    this.auth.login(this.formulaireDeConnexion.get('identifiant').value, this.formulaireDeConnexion.get('password').value)
      .subscribe(
        data => console.log(data),
        () => this.formulaireDeConnexion.setErrors({invalidLogin: true})
      );
  }

  signUp() {
    console.log(this.formulaireDinscription);
    this.auth.register(
      this.formulaireDinscription.get('pseudo').value,
      this.formulaireDinscription.get('motDePasse').value,
      this.formulaireDinscription.get('mail').value,
      this.formulaireDinscription.get('codePostal').value,
      this.formulaireDinscription.get('adresse').value,
      this.formulaireDinscription.get('nom').value,
      this.formulaireDinscription.get('prenom').value)
      .subscribe(
        data => console.log(data),
        () => this.formulaireDinscription.setErrors({invalidLogin: true})
      );
    this.formulaireDinscription.reset();
  }
}
