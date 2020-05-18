import {Injectable} from "@angular/core";
import {RequestServices} from "./request.services";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {DataService} from "./data.services";
import {Observable} from "rxjs";
import {PhotoModel} from "../models/photoModel";

/**
 * service qui gère les intéractions de photo avec l'api rest
 */
@Injectable({ providedIn: 'root' })
export class PhotoServices extends RequestServices
{
  url = this.data.baseUrl + '/photos/';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };

  constructor(public http: HttpClient,
              private data: DataService)
  {
    super(http, data);
  }

  /**
   * récupère la liste des url des photos
   */
  getPhotosArticles(): Observable<any>
  {
    return this.getGiveApp(this.url);
  }

  /**
   * récupère les photos d'un article
   * @param id : endpoint correspondant à l'id de l'article
   */
  getPhotosArticle(id: number): Observable<any>
  {
    return this.getGiveApp(this.url + "articles/" + id);
  }

  // ###############################################################
  /**
   * Méthode qui permet de poster une nouvelle url de photo
   * @param newPhoto
   */
  postPhoto(newPhoto: PhotoModel): Observable<any>
  {
    return this.postGiveApp(this.url, newPhoto);
  }
}
