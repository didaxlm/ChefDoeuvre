package fr.didier.giveapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.model.Photo;
import fr.didier.giveapp.app.repository.PhotoRepository;

@RequestMapping("/photos")
@RestController
public class PhotoController 
{
	@Autowired
	private PhotoRepository photoDepot;
	
	//affiche la liste des url des photos
	@GetMapping
	public List<Photo> afficherLiensPhotos() 
	{
		return photoDepot.findAll();
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
	public String supprimerPhoto(@RequestBody Photo idPhoto) 
	{
		photoDepot.delete(idPhoto);
		return "Photo supprimée";
	}
}
