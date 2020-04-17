import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {RequestServices} from "./request.services";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {DataService} from "./data.services";
import  {Categorie} from "../models/categorie";

@Injectable({ providedIn: 'root' })
export class CategorieService extends RequestServices
{

  url = this.data.baseUrl + '/categories';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };
  constructor(public http: HttpClient, private data:DataService) {
    super(http, data);
  }

  getCategorie(): Observable<any>{
    return  this.http
      .get<Categorie[]>(this.url);
  }
}
