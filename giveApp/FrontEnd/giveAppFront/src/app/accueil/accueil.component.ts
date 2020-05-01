import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ArticleModel} from "../partage/models/articleModel";
import {ArticleService} from "../partage/services/article.services";
import {PhotoModel} from "../partage/models/photoModel";
import {PhotoServices} from "../partage/services/photo.services";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  articleDetail: ArticleModel[];
  photoDetail: PhotoModel[];
  //@Input() index: number=ArticleModel[0];
  //nom: string = ArticleModel["nomArticle"];
  // @Output() categories: EventEmitter<ArticleModel> = new EventEmitter();
  nom = this.route.snapshot.paramMap.get('nomArticle');

  constructor(private articleService: ArticleService,
              private photoService: PhotoServices,
              private route: ActivatedRoute) { }

  afficherArticles()
  {
    this.articleService.getArticle().subscribe(articles => {
      this.articleDetail = articles;
    });
  }

  afficherUnArticle()
  {
    this.articleService.getUnArticle(this.nom).subscribe(articles => {
      this.articleDetail = articles;
      console.log(articles);
    });
  }
  afficherPhotos()
  {
    this.photoService.getPhotoArticle().subscribe(photos => {
      this.photoDetail = photos;
    });
  }
  ngOnInit(): void
  {
    this.afficherArticles();
    this.afficherPhotos();
  }
}

/*
import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {TypeService} from '../../service/type.service';
import {take} from 'rxjs/operators';
import {Type} from '../../model/type';

@Component({
  selector: 'app-filtre-projets',
  templateUrl: './filtre-projets.component.html',
  styleUrls: ['./filtre-projets.component.css']
})
export class FiltreProjetsComponent implements OnInit {
  // public types = new FormControl();
  typeList: Type[] = [];
  @Output() typesChangeEmitter = new EventEmitter<any>();
  readonly ITEM_ALL = 'Tous les projets';

  // private subscription: Subscription = null;

  constructor(private typeService: TypeService) {
  }

  // public ngOnDestroy(): void {
  //   this.subscription.unsubscribe();
  // }

  public ngOnInit(): void {
    this.typeService.getAllTypes().pipe(take(1)).subscribe(
      {
        next: data => {
          this.typeList = data;
        },
        error: (data) => {
          console.log(data);
        },
        complete: () => {
        }
      });
    this.typesChangeEmitter.emit('Tous');
      afficherUnArticle()
  {
    this.articleService.getUnArticle("table").subscribe(unArticle => {
      this.articleDetail = unArticle;
    });
  }
  }
 */
