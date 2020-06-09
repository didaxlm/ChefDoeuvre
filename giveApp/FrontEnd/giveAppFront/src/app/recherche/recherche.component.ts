import {Component, Input, OnInit} from '@angular/core';
import {CategorieModel} from '../partage/models/categorieModel';
import {CategorieServices} from '../partage/services/categorie.services';
import {ArticleModel} from '../partage/models/articleModel';
import {ArticleServices} from '../partage/services/article.services';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css']
})
export class RechercheComponent implements OnInit {

  @Input()
  categories: CategorieModel[];
  idCategorie: number;
  articles: ArticleModel[] = [];
  categorieSelected: CategorieModel = new CategorieModel();

  constructor(private categorieService: CategorieServices,
              public articleService: ArticleServices,
              private route: ActivatedRoute) { }

  afficherCategorie() {
    this.categorieService.getAllCategories().subscribe(categories => {
      this.categories = categories;
      console.log(this.categories);
    });
  }

  saisie(arg) {
    console.log(arg);
  }
  onSubmit(f) {
    console.log(f.value.category);
    this.idCategorie = f.value.category;
    this.afficherArticlesByCategorie();
  }
  afficherArticlesByCategorie() {
    // const params = this.route.snapshot.paramMap;
    // this.idCategorie = +params.get('id');
    this.articleService.getArticleByCategorie(this.idCategorie).subscribe(category => {
      this.categorieSelected = category;
    });
  }

  ngOnInit(): void {
    this.afficherCategorie();
  }
}
