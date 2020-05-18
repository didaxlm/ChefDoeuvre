import {Component, OnInit} from '@angular/core';
import {CategorieModel} from "../../partage/models/categorieModel";
import {CategorieServices} from "../../partage/services/categorie.services";
import {ArticleModel} from "../../partage/models/articleModel";
import {ArticleServices} from "../../partage/services/article.services";
import {FormBuilder} from "@angular/forms";
import {PhotoModel} from "../../partage/models/photoModel";
import {PhotoServices} from "../../partage/services/photo.services";

@Component({
  selector: 'app-don-articles',
  templateUrl: './don-articles.component.html',
  styleUrls: ['./don-articles.component.css']
})

export class DonArticlesComponent implements OnInit
{
  photos: PhotoModel[];
  categories: CategorieModel[];
  articles: ArticleModel[];
  newProduit: ArticleModel = new ArticleModel();
  newPhoto: PhotoModel = new PhotoModel();

  constructor(private articleService: ArticleServices,
              private categorieService: CategorieServices,
              private photoService: PhotoServices){
  }

  ngOnInit() {
    this.afficherCategorie();
  }

  saisie(arg){
    console.log(arg);
  }
  onSubmit(f)
  {
    console.log(f);

    // this.newProduit.photos = [];
    // this.newPhoto = {"urlPhoto": this.newPhoto.urlPhoto};
    // this.newProduit.photos.push(this.newPhoto);
    console.log(this.newProduit);
    this.ajouterArticle();

  }

  afficherCategorie()
  {
    this.categorieService.getAllCategories().subscribe(categories => {
      this.categories = categories;
    });
  }

  ajouterArticle()
  {
    this.articleService.postArticle(this.newProduit).subscribe(maj => {
      this.articleService.getAllArticles().subscribe((articles: ArticleModel[]) => {
        this.articles = articles;
      });
    });
  }
  // ajouterPhoto(){
  //   this.newPhoto.article = {'id': this.newProduit.id}
  //   this.photoService.postPhoto(this.newPhoto).subscribe(maj => {
  //     console.log(maj);
  //     this.photoService.getPhotosArticles().subscribe((photos: PhotoModel[]) => {
  //       this.photos = photos;
  //     });
  //   });
  // }
}
//set User = currentUser
