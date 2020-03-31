import { Article } from './article';

/**
 * objet user, possède une relation 1 - n avec article
 */
export class User
{
  id: number;
  typeUser: number;
  nom: string;
  prenom: string;
  motDePasse: string;
  mail: string;
  adresse: string;
  codePostal: number;
  pseudo: string;
  dateInscription: Date;
  article: Article;
}
