import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {CategorieModel} from "../partage/models/categorieModel";
import {CategorieService} from "../partage/services/categorie.services";
import {VilleModel} from "../partage/models/villeModel";
import {VilleServices} from "../partage/services/ville.services";

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css']
})
export class RechercheComponent implements OnInit {

  categories: CategorieModel[];
  villes: VilleModel[];

  @Output('envoiCategorie')
  envoiCategorieEmitter = new EventEmitter<any>();

  envoiCategorie() {
    this.envoiCategorieEmitter.emit(this.categories);
  }

  constructor(private categorieService: CategorieService, private villeService: VilleServices) { }

  ngOnInit(): void
  {
    this.categorieService.getCategorie().subscribe(categories => {
      this.categories = categories;
    });
    this.envoiCategorieEmitter.emit('categories');
    this.villeService.getVille().subscribe(villes => {
      this.villes = villes;
    });
    this.envoiCategorie();
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
  }
 */
