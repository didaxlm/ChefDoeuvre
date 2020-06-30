import {AbstractControl, AsyncValidatorFn, ValidationErrors} from '@angular/forms';
import {Observable, of} from 'rxjs';
import {catchError, map} from 'rxjs/operators';
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserServices} from '../partage/services/user.services';
import {DataService} from '../partage/services/data.services';
import {RequestServices} from '../partage/services/request.services';

@Injectable({providedIn: 'root'})
export class IdentificationValidation extends RequestServices {

  constructor(public http: HttpClient,
              public userServices: UserServices,
              private data: DataService) {
    super(http, data);
  }
  static nePeutContenirEspace(control: AbstractControl): ValidationErrors | null {
    if (control.value) {
      if ((control.value as string).indexOf(' ') >= 0) {
        return { nePeutContenirEspace: true };
      }
      return null;
    }
  }
  static caractereSpeciaux(control: AbstractControl): ValidationErrors | null {
    if ((control.value as string).indexOf('<>') >= 0) {
      return {caractereSpeciaux: true};
    }
    return null;
  }

  doitEtreUnique(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.userServices.isPseudoTaken(control.value).pipe(
        map(isTaken => (isTaken.resultat ? {doitEtreUnique: true} : null)),
        catchError(() => of(null)));
    };

  }
}
