import {Component, OnInit} from '@angular/core';
import {CategorieModel} from "../../partage/models/categorieModel";
import {CategorieServices} from "../../partage/services/categorie.services";
import {ArticleModel} from "../../partage/models/articleModel";
import {ArticleServices} from "../../partage/services/article.services";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-don-articles',
  templateUrl: './don-articles.component.html',
  styleUrls: ['./don-articles.component.css']
})

export class DonArticlesComponent implements OnInit
{

  categories: CategorieModel[];
  articles: ArticleModel[];
  newProduit: ArticleModel = new ArticleModel();

  constructor(private fb: FormBuilder,
              private articleService: ArticleServices,
              private categorieService: CategorieServices){
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
    this.ajouterArticle()
  }

  afficherCategorie()
  {

    this.categorieService.getAllCategories().subscribe(categories => {
      this.categories = categories;
    });
  }

  ajouterArticle()
  {
    this.articleService.postArticle(this.newProduit, this.newProduit.dateDepot).subscribe(maj => {
      this.articleService.getAllArticles().subscribe((articles: ArticleModel[]) => {
        this.articles = articles
      });
    });
  }
}
