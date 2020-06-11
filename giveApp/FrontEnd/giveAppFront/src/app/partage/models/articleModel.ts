import {UserModel} from './userModel';
import {CategorieModel} from './categorieModel';
import {PhotoModel} from './photoModel';

/**
 * objet article, possède des relations avec plusieurs objets:
 * n - 1 avec user, categorie et photo
 */
export class ArticleModel {
  id?: number;
  quantiteArticle?: number;
  nomArticle?: string;
  etatArticle?: string;
  lieuArticle?: string;
  dateDepot?: Date;
  user?: UserModel;
  categorie?: CategorieModel[];
  photo?: PhotoModel;
}
