import {ArticleModel} from "./articleModel";

/**
 * objet photo, possède une relation n - 1 avec article
 */
export class PhotoModel
{
  id: number;
  urlPhoto: string;
  article: ArticleModel;
}
