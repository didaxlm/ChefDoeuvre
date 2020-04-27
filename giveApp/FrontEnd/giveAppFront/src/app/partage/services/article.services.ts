import {Injectable} from "@angular/core";
import {RequestServices} from "./request.services";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {DataService} from "./data.services";
import {Observable} from "rxjs";
import {ArticleModel} from "../models/articleModel";

/**
 * service qui gère les interactions de article avec l'api rest
 */
@Injectable({ providedIn: 'root' })
export class ArticleService extends RequestServices
{
  url = this.data.baseUrl + '/articles';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };
  constructor(public http: HttpClient, private data:DataService) {
    super(http, data);
  }

  test (){ console.log("le service  est appelé"); }
  /**
   * recupère la liste des articles
   */
  getArticle(): Observable<any>
  {
    return this.getGiveApp(this.url);
  }

  postArticle(newArticle: ArticleModel): Observable<any>{
    return this.postGiveApp(this.url, newArticle);
  }
}
