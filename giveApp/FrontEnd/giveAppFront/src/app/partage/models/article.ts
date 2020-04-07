import {User} from "./user";
import {Ville} from "./ville";
import {Categorie} from "./categorie";
import {Photo} from "./photo";

/**
 * objet article, possède des relations avec plusieurs objets:
 * n - 1 avec user, ville et categorie
 * 1 - n avec photo
 */
export class Article
{
  id: number;
  quantiteArticle: number;
  nomArticle: string;
  etatArticle: string;
  dateDepot: Date;
  user: User[];
  ville: Ville[];
  categorie: Categorie;
  photo: Photo[];
}
