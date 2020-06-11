import { Injectable } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';
import {environment} from '../../../environments/environment';

/**
 * stocke les données utilisées par les autres services
 */
@Injectable({ providedIn: 'root' })
export class DataService {
  baseUrl = `${environment.apiUrl}`;
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor() { }
}
