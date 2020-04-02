import { Component, OnInit } from '@angular/core';
import {Article} from "../partage/models/article";
import {ArticleService} from "../partage/services/article.services";

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  articles: Article[];

  constructor(private articleService: ArticleService) { }

  ngOnInit(): void {
  }

}
