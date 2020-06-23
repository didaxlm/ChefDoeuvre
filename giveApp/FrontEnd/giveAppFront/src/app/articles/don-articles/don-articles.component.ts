import {Component, OnInit} from '@angular/core';
import {CategorieModel} from '../../partage/models/categorieModel';
import {CategorieServices} from '../../partage/services/categorie.services';
import {ArticleModel} from '../../partage/models/articleModel';
import {ArticleServices} from '../../partage/services/article.services';
import {Router} from '@angular/router';

@Component({
  selector: 'app-don-articles',
  templateUrl: './don-articles.component.html',
  styleUrls: ['./don-articles.component.css']
})

export class DonArticlesComponent implements OnInit {
  categories: CategorieModel[];
  articles: ArticleModel[];
  newProduit: ArticleModel = new ArticleModel();

  constructor(private articleService: ArticleServices,
              private router: Router,
              private categorieService: CategorieServices) {
  }

  ngOnInit() {
    this.afficherCategorie();
  }

  saisie(arg) {
    console.log(arg);
  }
  onSubmit(f) {
    console.log(f);
    console.log(this.newProduit);
    this.ajouterArticle();
    f.reset();
    alert('Vôtre article a été ajouté');
  }

  afficherCategorie() {
    this.categorieService.getAllCategories().subscribe(categories => {
      this.categories = categories;
    });
  }

  ajouterArticle() {
    this.articleService.postArticle(this.newProduit).subscribe(maj => {
      this.articleService.getAllArticles().subscribe((articles: ArticleModel[]) => {
        this.articles = articles;
      });
    });
  }
}
