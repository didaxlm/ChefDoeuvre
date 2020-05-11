import {UserModel} from "./userModel";
import {CategorieModel} from "./categorieModel";

/**
 * objet article, possède des relations avec plusieurs objets:
 * n - 1 avec user et categorie
 * 1 - n avec photo
 */
export class ArticleModel
{
  id: number;
  quantiteArticle: number;
  nomArticle: string;
  etatArticle: string;
  lieuArticle: string;
  dateDepot: Date;
  user: UserModel[];
  categorie: CategorieModel[];
}
