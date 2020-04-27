import {Injectable} from "@angular/core";
import {RequestServices} from "./request.services";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {DataService} from "./data.services";
import {Observable} from "rxjs";
import {VilleModel} from "../models/villeModel";

@Injectable({ providedIn: 'root'})
export class VilleServices extends RequestServices
{
  url = this.data.baseUrl + '/villes';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };

  constructor(public http: HttpClient, private data: DataService) {
    super(http, data);
  }

  getVille(): Observable<any>{
    return this.http
      .get<VilleModel[]>(this.url);
  }
}
