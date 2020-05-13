import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {JwtService} from "../partage/jwt/jwt.service";
import {IdentificationValidation} from "./identification.validation";

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})

export class ConnexionComponent
{

  constructor(private auth: JwtService) { }

  formulaireDeConnexion = new FormGroup({
    pseudo: new FormControl("", [
      Validators.required,
      Validators.minLength(3),
      IdentificationValidation.nePeutContenirEspace,
    ]),
    password: new FormControl("", [
      Validators.required,
      Validators.minLength(6),])
  });

  get pseudo() {
    return this.formulaireDeConnexion.get('pseudo');
  }

  get password() {
    return this.formulaireDeConnexion.get('password');
  }

  login() {
    this.auth.login(this.formulaireDeConnexion.get("pseudo").value, this.formulaireDeConnexion.get("password").value)
      .subscribe(
        data => console.log(data),
        () => this.formulaireDeConnexion.setErrors({invalidLogin: true})
        );
  }
}

// //////////////////////////////////////////////////////////////////
// export class ConnexionComponent implements OnInit
// {
//   connexionForm: FormGroup;
//   submitted: false;
//
//   user: UserModel = new UserModel();
//
//   constructor(private fb: FormBuilder, private auth: JwtService, private router: Router) { }
//
//   ngOnInit(): void {
//     this.connexionForm = this.fb.group({
//       pseudo: "",
//       password: ""
//     });
//   }
//   saisie(arg){
//     console.log(arg);
//   }
//
//   onSubmit(f){
//     console.log(f)
//     this.redirection();
//   }
//   redirection()
//   {
//     this.auth.login(this.connexionForm.get("pseudo").value, this.connexionForm.get("password").value)
//       .subscribe(data =>console.log(data));
//   }
//
// }
