import { Injectable } from "@angular/core";
import { HttpHeaders } from "@angular/common/http";

/*
 * stocke les données utilisées par les autres services
 */
@Injectable({
  providedIn: 'root'
})
export class DataService {
  baseUrl = 'http://localhost:8080';
}
