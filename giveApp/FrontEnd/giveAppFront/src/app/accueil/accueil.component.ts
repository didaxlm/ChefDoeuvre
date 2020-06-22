import {Component, Input, OnInit} from '@angular/core';
import {ArticleModel} from '../partage/models/articleModel';
import {ArticleServices} from '../partage/services/article.services';
import {PhotoModel} from '../partage/models/photoModel';
import {PhotoServices} from '../partage/services/photo.services';
import {JwtService} from '../partage/jwt/jwt.service';
import {CategorieModel} from '../partage/models/categorieModel';
import {CategorieServices} from '../partage/services/categorie.services';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  articlesDetails: ArticleModel[];
  photosDetail: PhotoModel[];
  categories: CategorieModel[];
  idCategorie: number;

  constructor(private articleService: ArticleServices,
              private photoService: PhotoServices,
              private categorieService: CategorieServices,
              public jwt: JwtService) { }

  afficherArticles() {
    this.articleService.getAllArticles().subscribe(articles => {
      this.articlesDetails = articles;
    });
  }

  afficherCategorie() {
    this.categorieService.getAllCategories().subscribe(categories => {
      this.categories = categories;
    });
  }

  afficherPhotos() {
    this.photoService.getPhotosArticles().subscribe(photos => {
      this.photosDetail = photos;
    });
  }

  saisie(arg) {
    console.log(arg);
  }
  onSubmit(f) {
    this.idCategorie = f.value.category;
  }

  ngOnInit(): void {
    this.afficherCategorie();
    this.afficherArticles();
    this.afficherPhotos();
  }
}
// afficherArticlesByCategorie() {
//   const params = this.route.snapshot.paramMap;
//   this.idCategorie = +params.get('id');
//   this.articleService.getArticleByCategorie(this.idCategorie).subscribe(category => {
//     this.categorieSelected = category;
//   });
// }
