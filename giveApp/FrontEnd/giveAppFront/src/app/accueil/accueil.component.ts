import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ArticleModel} from "../partage/models/articleModel";
import {ArticleServices} from "../partage/services/article.services";
import {PhotoModel} from "../partage/models/photoModel";
import {PhotoServices} from "../partage/services/photo.services";
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  articlesDetails: ArticleModel[];
  unArticle: ArticleModel[] = [];
  photosDetail: PhotoModel[];

  //@Output() articleDetail = new EventEmitter();

  constructor(private articleService: ArticleServices,
              private photoService: PhotoServices,
              private route: ActivatedRoute) { }

  afficherArticles()
  {
    this.articleService.getAllArticles().subscribe(articles => {
      this.articlesDetails = articles;
    });
  }

  afficherPhotos()
  {
    this.photoService.getPhotosArticles().subscribe(photos => {
      this.photosDetail = photos;
    });
  }
  ngOnInit(): void
  {
    this.afficherArticles();
    this.afficherPhotos();
  }
}
// ##################################################################
// ngOnClick(){
//   this.articleService.getAllArticles().pipe(take(1)).subscribe(
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
//   this.articleDetail.emit();
// }
// ##################################################################
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
  {
    this.articleService.getUnArticle("table").subscribe(unArticle => {
      this.articleDetail = unArticle;
    });
  }
  }
 */
