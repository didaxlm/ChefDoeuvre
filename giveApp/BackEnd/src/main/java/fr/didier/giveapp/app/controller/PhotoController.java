package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.exceptions.NotFoundException;
import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.model.Photo;
import fr.didier.giveapp.app.repository.ArticleRepository;
import fr.didier.giveapp.app.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequestMapping("/photos")
@RestController
public class PhotoController
{
	@Autowired
	private PhotoRepository photoDepot;

	@Autowired
	private ArticleRepository articleDepot;

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Méthode qui affiche la liste des url des photos
	 * @return toute la liste
	 */
	@GetMapping
	public List<Photo> afficherLiensPhotos() 
	{
		return photoDepot.findAll();
	}
	/**
	 * Methode qui récupère une liste de photo en fonction de l'id de l'article
	 * @param articleId précisé dans l'url (ex : /articles/1)
	 * @return la ou les photos de l'article
	 * @throws Exception si l'article de la photo n'existe pas
	 */
	@GetMapping("/articles/{articleId}")
	public Set<Photo> afficherPhotoArticle(@PathVariable int articleId) throws Exception
	{
		Set<Photo> retourPhoto ;
		Optional<Article> articleFound = articleDepot.findById(articleId);

		if (articleFound.isPresent()){
			retourPhoto = articleFound.get().getPhotos();
		} else {
			throw new NotFoundException();
		}
		return retourPhoto;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * ajoute une URL à la liste
	 * @param urlPhoto: correspond à l'URL de la photo passée dans le Json
	 * @return l'url ajouté
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Photo ajouterPhoto(@RequestBody Photo urlPhoto)
	{

		return photoDepot.saveAndFlush(urlPhoto);
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Méthode qui supprime l'URL d'une photo de la BDD
	 * @param photoId: correspond aux données de l'article passé dans le json
	 * @throws Exception la photo n'existe pas
	 */
	@DeleteMapping("{photoId}")
	public void supprimerPhoto(@PathVariable int photoId) throws Exception
	{
		if (photoDepot.existsById(photoId)){
			photoDepot.deleteById(photoId);
		} else {
			throw new NotFoundException();
		}
	}
}
