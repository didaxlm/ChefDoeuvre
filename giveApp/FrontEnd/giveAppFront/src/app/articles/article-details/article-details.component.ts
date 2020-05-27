import {Component, OnInit} from '@angular/core';
import {ArticleModel} from "../../partage/models/articleModel";
import {ArticleServices} from "../../partage/services/article.services";
import {PhotoModel} from "../../partage/models/photoModel";
import {PhotoServices} from "../../partage/services/photo.services";
import {ActivatedRoute} from "@angular/router";
import {JwtService} from "../../partage/jwt/jwt.service";


@Component({
  selector: 'app-article-details',
  templateUrl: './article-details.component.html',
  styleUrls: ['./article-details.component.css']
})
export class ArticleDetailsComponent implements OnInit {

  idArticle: number;
  articleDetails : ArticleModel;
  produit: ArticleModel[];

  constructor(private route: ActivatedRoute,
              private articleService: ArticleServices,
              public jwt: JwtService) { }

  ngOnInit() {
    let params = this.route.snapshot.paramMap;
    this.idArticle = +params.get('id');
    this.articleService.getUnArticle(this.idArticle).subscribe(article => {
      this.articleDetails = article;
    });
  }
  supprimerArticle()
  {
    this.articleService.deleteArticle(this.idArticle).subscribe(maj => {
      this.articleService.getAllArticles().subscribe((articles: ArticleModel[]) => {
        this.produit = articles;
      });
    });
  }

  // #################################################################

  // articlesDetails : ArticleModel[];
  // photoArticle : PhotoModel;
  // unArticle: ArticleModel[] = [];
  // @Output() articleDetails = new EventEmitter();
  // nom = this.route.snapshot.paramMap.get("id");
  // //@Input() index: number=ArticleModel[0];
  //
  // constructor(private articleService: ArticleService,
  //             private photoService: PhotoServices,
  //             private route: ActivatedRoute) { }
  //
  // afficherUnArticle()
  // {
  //   this.route.paramMap
  //     .subscribe(params => {
  //
  //     });
  //
  // }
  //
  // afficherArticles()
  // {
  //   this.articleService.getArticle().subscribe(articles => {
  //     this.articlesDetails = articles;
  //   });
  // }
  // ngOnInit(): void
  // {
  //   //this.afficherArticles();
  //   // this.afficherUnArticle();
  //   // console.log("test");
  // }
// #################################################################
  // afficherUnArticle()
  // {
  //   this.articleService.getArticle().pipe(take(1)).subscribe(
  //     {
  //       next: data => {
  //         this.unArticle = data;
  //       },
  //       error: (data) => {
  //         console.log(data);
  //       },
  //       complete: () => {
  //       }
  //     });
  //   this.articleDetails.emit();
  // }
}
