import {Injectable} from "@angular/core";
import {RequestServices} from "./request.services";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {DataService} from "./data.services";
import {Observable} from "rxjs";
import {Article} from "../models/article";

/**
 * service qui gère les interactions de article avec l'api rest
 */
@Injectable({ providedIn: 'root' })
export class ArticleService extends RequestServices
{
  url = this.data.baseUrl + '/articles';
  list = null;
  article = null;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(public http: HttpClient, private data: DataService) {
    super(http, data);
  }

  /**
   * recupère la liste des articles
   */
  getList(): Observable<any> {
    return this.http.get<Article[]>(this.url);
  }
}
