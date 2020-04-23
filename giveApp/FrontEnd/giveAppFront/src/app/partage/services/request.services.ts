import { Injectable } from "@angular/core";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { DataService } from "./data.services";

/**
 * parent des autres services qui communoque avec l'api
 */
@Injectable({ providedIn: 'root' })
export class RequestServices
{
  constructor(public http: HttpClient, public dataService: DataService) { }

  /**
   * effectue une requete Get
   * @param apiUrl Endpoint à joindre
   */
  public getGiveApp(apiUrl: string): Observable<any>
  {
    return this.http.get<any>(apiUrl);
  }

  /**
   * effectue une requete Post
   * @param apiUrl : endpoint à joindre
   * @param addObjet : article à envoyer
   */
  public postGiveApp(apiUrl: string, addObjet: any): Observable<any>
  {
    return this.http.post<any>(apiUrl, addObjet, this.dataService.httpOptions);
  }
}
