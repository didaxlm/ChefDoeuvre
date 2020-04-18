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
@CrossOrigin(origins = "http://localhost:4200")
public class PhotoController 
{
	@Autowired
	private PhotoRepository photoDepot;

	@Autowired
	private ArticleRepository articleDepot;
	
	//affiche la liste des url des photos
	@GetMapping
	public List<Photo> afficherLiensPhotos() 
	{
		return photoDepot.findAll();
	}
	
	/*
	 * methode qui recupere une liste de photo en fonction de l'id de l'article
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
	/*
	 * ajoute une URL à la liste
	 * @param urlPhoto: correspond à l'URL de la photo passée dans le Json
	 * @return
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Photo ajouterPhoto(@RequestBody Photo urlPhoto)
	{
		return photoDepot.saveAndFlush(urlPhoto);
	}

	/*
	 * supprime une URL de la photo de la BDD
	 * @param idPhoto: correspond aux données de l'article passé dans le json
	 * @return
	 */
	@DeleteMapping
	public void supprimerPhoto(@RequestBody Photo idPhoto)
	{
		photoDepot.delete(idPhoto);
	}

}
