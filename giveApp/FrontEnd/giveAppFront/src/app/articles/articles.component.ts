import {Component, OnInit} from '@angular/core';
import {ArticleModel} from '../partage/models/articleModel';
import {ArticleServices} from '../partage/services/article.services';
import {JwtService} from '../partage/jwt/jwt.service';
import {ActivatedRoute} from '@angular/router';
import {CategorieModel} from '../partage/models/categorieModel';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {
  idCategorie: number;
  articleDetails: ArticleModel[];
  categorie: CategorieModel[] = [];

  constructor(private route: ActivatedRoute,
              private articleService: ArticleServices,
              public jwt: JwtService) { }

  ngOnInit() {
    const params = this.route.snapshot.paramMap;
    this.idCategorie = +params.get('id');
    this.articleService.getArticleByCategorie(this.idCategorie).subscribe(article => {
      this.articleDetails = article;
    });
  }
}
