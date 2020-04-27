import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, Validators} from "@angular/forms";
import {ArticleModel} from "../partage/models/articleModel";
import {Router} from "@angular/router";
import {Observable} from "rxjs";

@Component({
  selector: 'app-don-objets',
  templateUrl: './don-objets.component.html',
  styleUrls: ['./don-objets.component.css']
})
export class DonObjetsComponent implements OnInit
{

  // attributs de formulaire
  formArticleNom = new FormControl('', Validators.required);
  formArticleCategorie = new FormControl('', Validators.required);
  formArticleLieu = new FormControl('', Validators.required);

  //attributs des datas
  private nomArticle: string = "";
  private articleCategorie: string = "";
  private lieuArticle: string = "";

  article: ArticleModel = new ArticleModel();

  constructor(private fb: FormBuilder) { }

  ngOnInit()
  {
    this.getData();
  }

  /**
   * récupère les informations du formulaire
   */
  getData()
  {
    this.nomArticle = this.formArticleNom.value;
    this.articleCategorie = this.formArticleCategorie.value;
    this.lieuArticle = this.formArticleLieu.value;
  }


}
