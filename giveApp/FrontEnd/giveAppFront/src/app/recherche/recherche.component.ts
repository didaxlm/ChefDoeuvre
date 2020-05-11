import {Component, OnInit} from '@angular/core';
import {CategorieModel} from "../partage/models/categorieModel";
import {CategorieServices} from "../partage/services/categorie.services";
import {ArticleServices} from "../partage/services/article.services";
import {ArticleModel} from "../partage/models/articleModel";

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css']
})
export class RechercheComponent implements OnInit {

  categories: CategorieModel[];
  articles: ArticleModel[];

  constructor(private categorieService: CategorieServices,
              private articleService: ArticleServices) { }

  afficherCategorie()
  {
    this.categorieService.getAllCategories().subscribe(categories => {
      this.categories = categories;
    });
  }
  afficherVilles()
  {
    this.articleService.getArticleByLieux(this.articles["lieuArticle"]).subscribe(villes => {
      this.articles = villes;
    });
  }

  ngOnInit(): void
  {
    this.afficherCategorie();
    //this.afficherVilles();
  }
}

