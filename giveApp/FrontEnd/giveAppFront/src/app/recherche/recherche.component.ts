import { Component, OnInit } from '@angular/core';
import {Categorie} from "../partage/models/categorie";
import {CategorieService} from "../partage/services/categorie.services";
import {Ville} from "../partage/models/ville";
import {VilleServices} from "../partage/services/ville.services";

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css']
})
export class RechercheComponent implements OnInit {

  categories: Categorie[];
  villes: Ville[];

  constructor(private categorieService: CategorieService, private villeService: VilleServices) { }

  ngOnInit(): void
  {
    this.categorieService.getCategorie().subscribe(categories => {
      this.categories = categories;
    });
    this.villeService.getVille().subscribe(villes => {
      this.villes = villes;
    });
  }
}
