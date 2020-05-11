import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {RequestServices} from "./request.services";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {DataService} from "./data.services";

@Injectable({ providedIn: 'root' })
export class CategorieServices extends RequestServices
{

  url = this.data.baseUrl + '/categories/';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };
  constructor(public http: HttpClient,
              private data:DataService)
  {
    super(http, data);
  }

  /**
   * Récupère la liste des catégories
   */
  getAllCategories(): Observable<any>
  {
    return  this.getGiveApp(this.url);
  }
}
