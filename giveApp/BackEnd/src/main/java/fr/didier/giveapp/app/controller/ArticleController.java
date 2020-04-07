package fr.didier.giveapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.repository.ArticleRepository;

@RequestMapping("/articles")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController
{
	@Autowired
	private ArticleRepository articleDepot;
	
	//affiche la liste des articles
	@GetMapping
	public List<Article> afficherListeArticle() 
	{
		return articleDepot.findAll();
	}
	
	/*
	 * ajoute un article à la liste
	 * @param dataArticle: correspond aux données de l'article passées dans le Json
	 * @return
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Article ajouterArticle(@RequestBody Article dataArticle) 
	{
		return articleDepot.saveAndFlush(dataArticle);
	}
	
	/*
	 * supprime un objet de la BDD
	 * @param articleData: correspond aux données de l'article passé dans le json
	 * @return
	 */
	@DeleteMapping
	public void supprimerArticle(@RequestBody Article articleData) 
	{
		//TODO gerer le statut quand on supprime un article qui n'existe pas et verif si photo supprimée
		articleDepot.delete(articleData);
		
	}
}
