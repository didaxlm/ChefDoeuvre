package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.exceptions.NotFoundException;
import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	 * supprime un article de la BDD
	 * @param articleId: correspond aux données de l'article passées dans l'url'
	 * @return
	 */
	@DeleteMapping("{articleId}")
	public void supprimerArticle(@PathVariable int articleId) throws Exception
	{
		if (articleDepot.existsById(articleId)){
		articleDepot.deleteById(articleId);
		} else {
			throw new NotFoundException();
		}
	}
}
