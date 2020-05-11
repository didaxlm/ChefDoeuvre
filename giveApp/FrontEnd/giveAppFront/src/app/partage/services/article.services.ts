import {Injectable} from "@angular/core";
import {RequestServices} from "./request.services";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {DataService} from "./data.services";
import {Observable} from "rxjs";
import {ArticleModel} from "../models/articleModel";

/**
 * service qui gère les intéractions de article avec l'api rest
 */
@Injectable({ providedIn: 'root' })
export class ArticleServices extends RequestServices
{
  url = this.data.baseUrl + '/articles/';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };
  constructor(public http: HttpClient,
              private data: DataService)
  {
    super(http, data);
  }

  /**
   * récupère la liste des articles
   */
  getAllArticles(): Observable<any>
  {
    return this.getGiveApp(this.url);
  }

  /**
   * Récupère les détails d'un article
   * @param id : endpoint à joindre
   */
  getUnArticle(id: number): Observable<any>
  {
    return this.getGiveApp(this.url+ "id/" + id);
  }

  /**
   * Récupère la liste des articles en fonction des villes
   * @param ville : endpoint à joindre
   */
  getArticleByLieux(ville: string): Observable<any>
  {
    return this.getGiveApp(this.url + ville);
  }
// ###############################################################
  /**
   * Méthode qui permet de poster un nouvel article
   * @param newArticle
   */
  postArticle(newArticle: ArticleModel, newDate: Date): Observable<any>{
    return this.postGiveApp(this.url, newArticle);
  }
}
