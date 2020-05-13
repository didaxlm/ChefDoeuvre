import {AbstractControl, ValidationErrors} from "@angular/forms";
import {UserModel} from "../partage/models/userModel";

export class IdentificationValidation {

  users:  UserModel[];

  static nePeutContenirEspace(control: AbstractControl) : ValidationErrors | null
  {
    if ((control.value as string).indexOf(' ') >= 0)
      return { nePeutContenirEspace: true };
    return null;
  }

  static doitEtreUnique(control: AbstractControl) : Promise<ValidationErrors | null>
  {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (control.value === 'toto')
          resolve({ doitEtreUnique: true });
        else resolve(null);
      }, 2000);
    });
  }
}
