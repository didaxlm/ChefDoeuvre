import {Injectable} from "@angular/core";
import {RequestServices} from "./request.services";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {DataService} from "./data.services";
import {Observable} from "rxjs";
import {Photo} from "../models/photo";

@Injectable({ providedIn: 'root' })
export class PhotoServices extends RequestServices
{
  url = this.data.baseUrl + '/photos';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };

  constructor(public http: HttpClient, private data: DataService) {
    super(http, data);
  }

  getPhoto(): Observable<any>{
    return this.http
      .get<Photo[]>(this.url);
  }
}
