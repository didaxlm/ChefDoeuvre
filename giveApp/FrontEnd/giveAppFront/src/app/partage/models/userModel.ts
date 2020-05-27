import { ArticleModel } from './articleModel';

/**
 * objet user, possède une relation 1 - n avec article
 */
export class UserModel
{
  id: number;
  role: string;
  nom: string;
  prenom: string;
  motDePasse: string;
  mail: string;
  adresse: string;
  codePostal: string;
  pseudo?: string;
  dateInscription: Date;
  article: ArticleModel;

}
