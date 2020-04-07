import { Component, OnInit } from '@angular/core';
import {Article} from "../partage/models/article";
import {ArticleService} from "../partage/services/article.services";
import { HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  articles: Article[];

  constructor(private articleService: ArticleService) { }


  ngOnInit(): void {
    this.articleService.test();
    this.articleService.getArticle().subscribe(articles => {
      this.articles = articles;
    });
    console.log(this.articleService.getArticle());
  }
}
