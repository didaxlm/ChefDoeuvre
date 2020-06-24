import { Injectable } from '@angular/core';
import {RequestServices} from './request.services';
import {HttpClient} from '@angular/common/http';
import {DataService} from './data.services';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FaqService extends RequestServices {
  url = this.data.baseUrl + '/faq/';

  constructor( public http: HttpClient,
               private data: DataService) {
    super(http, data);
  }

  /**
   * Récupère la liste des questions et réponses
   */
  getAllFaq(): Observable<any> {
    return this.getGiveApp(this.url);
  }
}
