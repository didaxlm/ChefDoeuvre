import {Article} from "./article";

/**
 * objet photo, possède une relation n - 1 avec article
 */
export class Photo
{
  id: number;
  urlPhoto: string;
  article: Article;
}
