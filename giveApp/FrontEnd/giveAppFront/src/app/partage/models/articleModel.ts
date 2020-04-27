import {UserModel} from "./userModel";
import {VilleModel} from "./villeModel";
import {CategorieModel} from "./categorieModel";

/**
 * objet article, possède des relations avec plusieurs objets:
 * n - 1 avec user, ville et categorie
 * 1 - n avec photo
 */
export class ArticleModel
{
  id: number;
  quantiteArticle: number;
  nomArticle: string;
  etatArticle: string;
  dateDepot: Date;
  user: UserModel[];
  ville: VilleModel[];
  categorie: CategorieModel;
}
