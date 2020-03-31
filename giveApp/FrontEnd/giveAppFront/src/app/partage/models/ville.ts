import {Article} from "./article";

/**
 * objet ville, possède une relation 1 - n avec article
 */
export class Ville
{
  id: number;
  nomVille: string;
  article: Article;
}
