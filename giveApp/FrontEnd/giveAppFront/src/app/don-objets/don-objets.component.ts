import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl} from "@angular/forms";
import {Article} from "../partage/models/article";
import {Router} from "@angular/router";

@Component({
  selector: 'app-don-objets',
  templateUrl: './don-objets.component.html',
  styleUrls: ['./don-objets.component.css']
})
export class DonObjetsComponent implements OnInit
{

  // attributs de formulaire
  formArticleNom = new FormControl();
  formArticleCategorie = new FormControl();
  formArticleLieu = new FormControl();

  //attributs des datas
  private nomArticle: string = "";
  private articleCategorie: string = "";
  private lieuArticle: string = "";

  article: Article = new Article();

  //constructor(private fb: FormBuilder, private router: Router) { }

  ngOnInit()
  {
    //this.redirect();
  }

  /**
   * renvoie vers la
   */
}
