import {Component, OnInit} from '@angular/core';
import {ArticleModel} from "../partage/models/articleModel";
import {ArticleServices} from "../partage/services/article.services";
import {PhotoModel} from "../partage/models/photoModel";
import {PhotoServices} from "../partage/services/photo.services";
import {JwtService} from "../partage/jwt/jwt.service";


@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  articlesDetails: ArticleModel[];
  photosDetail: PhotoModel[];

  constructor(private articleService: ArticleServices,
              private photoService: PhotoServices,
              public jwt: JwtService) { }

  afficherArticles()
  {
    this.articleService.getAllArticles().subscribe(articles => {
      this.articlesDetails = articles;
    });
  }

  afficherPhotos()
  {
    this.photoService.getPhotosArticles().subscribe(photos => {
      this.photosDetail = photos;
    });
  }
  ngOnInit(): void
  {
    this.afficherArticles();
    this.afficherPhotos();
  }
}

