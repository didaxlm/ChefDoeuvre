import {Injectable} from "@angular/core";
import {RequestServices} from "./request.services";
import {HttpClient} from "@angular/common/http";
import {DataService} from "./data.services";
import {Observable} from "rxjs";

@Injectable({ providedIn: 'root' })
export class UserServices  extends RequestServices
{
  url = this.data.baseUrl + '/users/';

  constructor(public  http: HttpClient,
              private data: DataService)
  {
    super(http, data);
  }

  /**
   * Récupère les détails d'un utilisateur
   * @param id : endpoint à joindre
   */
  getUnUser(id: number): Observable<any>
  {
    return this.getGiveApp(this.url+ "id/" + id);
  }
}
