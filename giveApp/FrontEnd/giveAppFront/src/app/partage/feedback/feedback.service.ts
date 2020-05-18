import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FeedbackService
{

  info : BehaviorSubject<string> = new BehaviorSubject<string>(undefined);
  warning : BehaviorSubject<string> = new BehaviorSubject<string>(undefined);

  constructor() { }

  /**
   * Handle Http operation that failed
   * permet à l'app de continuer
   * @param operation - nom de l'opération qui échoue
   * @param result - valeur optionelle qui retourne le résultat observable
   */
  handleError<T> (operation = 'operation', result?: T){

    return (error: any): Observable<T> => {
      this.warning.next(`${operation} failed: ${error.message}`);

      console.log(`${operation} failed`); // TODO remove console

      //laisse l'application tourner en retournant un résultat vide
      return of(result as T);
    }
  }
}
