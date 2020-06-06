import {Component, OnInit} from '@angular/core';
import {ArticleModel} from "../../partage/models/articleModel";
import {ArticleServices} from "../../partage/services/article.services";
import {ActivatedRoute} from "@angular/router";
import {JwtService} from "../../partage/jwt/jwt.service";

@Component({
  selector: 'app-article-details',
  templateUrl: './article-details.component.html',
  styleUrls: ['./article-details.component.css']
})
export class ArticleDetailsComponent implements OnInit
{
  idArticle: number;
  articleDetails: ArticleModel;
  produit: ArticleModel[];

  constructor(private route: ActivatedRoute,
              private articleService: ArticleServices,
              public jwt: JwtService) { }

  ngOnInit() {
    let params = this.route.snapshot.paramMap;
    this.idArticle = +params.get('id');
    this.articleService.getUnArticle(this.idArticle).subscribe(article => {
      this.articleDetails = article;
    });
  }
  supprimerArticle()
  {
    this.articleService.deleteArticle(this.idArticle).subscribe(() => {
      this.articleService.getAllArticles().subscribe((articles: ArticleModel[]) => {
        this.produit = articles;
      });
    });
  }
}
