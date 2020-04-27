import {ArticleModel} from "./articleModel";

/**
 * objet categorie, possède une relation 1 - n avec article
 */
export  class CategorieModel
{
  id: number;
  typeCategorie: string;
  article: ArticleModel;
}
