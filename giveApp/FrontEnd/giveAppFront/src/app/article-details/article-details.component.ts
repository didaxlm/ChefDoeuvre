import {Component, Input, OnInit, Output} from '@angular/core';
import {ArticleModel} from "../partage/models/articleModel";
import {PhotoModel} from "../partage/models/photoModel";
import {ArticleService} from "../partage/services/article.services";
import {PhotoServices} from "../partage/services/photo.services";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-article-details',
  templateUrl: './article-details.component.html',
  styleUrls: ['./article-details.component.css']
})
export class ArticleDetailsComponent implements OnInit {

  articleDetail : ArticleModel;
  photoArticle : PhotoModel;
  nom = this.route.snapshot.paramMap.get('nomArticle');
  //@Input() index: number=ArticleModel[0];

  constructor(private articleService: ArticleService,
              private photoService: PhotoServices,
              private route: ActivatedRoute) { }

  afficherUnArticle()
  {
    this.articleService.getUnArticle(this.nom).subscribe(articles => {
      this.articleDetail = articles;
      console.log(articles);
    });
  }



  ngOnInit(): void
  {
    this.afficherUnArticle();
    console.log(this.articleDetail);
  }
}
