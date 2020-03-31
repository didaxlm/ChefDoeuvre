import {Article} from "./article";

/**
 * objet categorie, possède une relation 1 - n avec article
 */
export  class Categorie
{
  id: number;
  typeCategorie: string;
  article: Article;
}
