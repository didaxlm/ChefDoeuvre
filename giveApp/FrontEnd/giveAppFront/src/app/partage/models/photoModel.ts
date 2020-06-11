import {ArticleModel} from './articleModel';

/**
 * objet photo, possède une relation 1 - n avec article
 */
export class PhotoModel {
  id?: number;
  urlPhoto?: string;
  article?: ArticleModel;
}
