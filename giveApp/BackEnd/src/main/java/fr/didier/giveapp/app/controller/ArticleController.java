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
import fr.didier.giveapp.app.repository.ArticleRepository;

@RequestMapping("/articles")
@RestController
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
	public String supprimerArticle(@RequestBody Article articleData) 
	{
		articleDepot.delete(articleData);
		return "article supprimé";
	}
}
