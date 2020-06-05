import {Component, OnInit} from '@angular/core';
import {CategorieModel} from "../partage/models/categorieModel";
import {CategorieServices} from "../partage/services/categorie.services";
import {ArticleServices} from "../partage/services/article.services";
import {ArticleModel} from "../partage/models/articleModel";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css']
})
export class RechercheComponent implements OnInit {

  categories: CategorieModel[];
  articles: ArticleModel[];
  categorieSelected: CategorieModel = new CategorieModel();
  idCategorie: number;

  constructor(private categorieService: CategorieServices,
              private route: ActivatedRoute,
              private articleService: ArticleServices) { }

  afficherCategorie()
  {
    this.categorieService.getAllCategories().subscribe(categories => {
      this.categories = categories;
      console.log(this.categories);
    });
  }

  saisie(arg){
    console.log(arg);
  }
  onSubmit(f){
    console.log(f.value.category);
    this.idCategorie = f.value.category;
    this.afficherArticlesByCategorie();
  }
  afficherArticlesByCategorie(){
    // let params = this.route.snapshot.paramMap;
    // this.idCategorie = +params.get('id');
    this.articleService.getArticleByCategorie(this.idCategorie).subscribe(category => {
      this.categorieSelected = category
    })
  }

  ngOnInit(): void
  {
    this.afficherCategorie();
  }
}
