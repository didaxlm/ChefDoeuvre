import {ArticleModel} from "./articleModel";

/**
 * objet ville, possède une relation 1 - n avec article
 */
export class VilleModel
{
  id: number;
  nomVille: string;
  article: ArticleModel;
}
