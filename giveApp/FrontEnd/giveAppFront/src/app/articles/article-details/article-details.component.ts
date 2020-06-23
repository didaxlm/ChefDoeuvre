import {Component, OnInit} from '@angular/core';
import {ArticleModel} from '../../partage/models/articleModel';
import {ArticleServices} from '../../partage/services/article.services';
import {ActivatedRoute, Router} from '@angular/router';
import {JwtService} from '../../partage/jwt/jwt.service';

@Component({
  selector: 'app-article-details',
  templateUrl: './article-details.component.html',
  styleUrls: ['./article-details.component.css']
})
export class ArticleDetailsComponent implements OnInit {
  idArticle: number;
  articleDetails: ArticleModel;
  produit: ArticleModel[];
  user = 0;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private articleService: ArticleServices,
              public jwt: JwtService) { }

  ngOnInit() {
    const params = this.route.snapshot.paramMap;
    this.idArticle = +params.get('id');
    this.articleService.getUnArticle(this.idArticle).subscribe(article => {
      this.articleDetails = article;
    });
    this.user = this.jwt.getUserId();
    console.log(this.user);
  }
  supprimerArticle() {
    this.articleService.deleteArticle(this.idArticle).subscribe(() => {
      this.articleService.getAllArticles().subscribe((articles: ArticleModel[]) => {
        this.produit = articles;
        alert('Vôtre article à été supprimé');
        this.router.navigate(['/']);
      });
    });
  }
}
