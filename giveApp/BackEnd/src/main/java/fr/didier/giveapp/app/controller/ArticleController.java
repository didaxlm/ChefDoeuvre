package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.exceptions.NotFoundException;
import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.model.Categorie;
import fr.didier.giveapp.app.model.Ville;
import fr.didier.giveapp.app.repository.ArticleRepository;
import fr.didier.giveapp.app.repository.CategorieRepository;
import fr.didier.giveapp.app.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/articles")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController
{
	@Autowired
	private ArticleRepository articleDepot;

	@Autowired
	private CategorieRepository categorieDepot;

	@Autowired
	private VilleRepository villeDepot;

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Méthode qui affiche la liste des articles
	 * @return toute la liste
	 */
	@GetMapping
	public List<Article> afficherListeArticles()
	{
		return articleDepot.findAll();
	}

	/**
	 * Méthode qui récupère un article en particulier
	 * @param nomArticle : précisé dans l'url (ex : /articles/table)
	 * @return l'article précisé
	 */
	@GetMapping("{nomArticle}")
	public Optional<Article> afficherArticle(@PathVariable String nomArticle)
	{
		return articleDepot.findByNomArticle(nomArticle);
	}

//	@RequestMapping(value = "/details/", params = {"nomArticle","quantiteArticle","etatArticle"})
//	public Article afficherDetailsPrincipaux(String nomArticle, int quantiteArticle, String etatArticle){
//		Article articleDetail = new Article(nomArticle, quantiteArticle, etatArticle);
//	}
	/**
	 * Méthode qui affiche une liste d'article en fonction de l'id de la catégorie
	 * @param categorieId : précisé dans l'url (ex : /categories/1)
	 * @return le ou les articles de la catégorie
	 * @throws Exception si la catégorie de l'article n'existe pas
	 */
	@GetMapping("/categories/{categorieId}")
	public Set<Article> afficherArticlesByCategorie(@PathVariable int categorieId) throws Exception
	{
		Set<Article> retourArticle ;
		Optional<Categorie> categorieFound = categorieDepot.findById(categorieId);

		if (categorieFound.isPresent()){
			retourArticle = categorieFound.get().getArticles();
		} else {
			throw new NotFoundException();
		}
		return retourArticle;
	}

	/**
	 * Méthode qui affiche les articles par ville
	 * @param villeId : précisé dans l'url (ex : /villes/2)
	 * @return le ou les articles de la ville
	 * @throws Exception si la ville de l'article n'existe pas
	 */
	@GetMapping("/villes/{villeId}")
	public Set<Article> afficherArticlesByVille(@PathVariable int villeId) throws Exception
	{
		Set<Article> retourArticle ;
		Optional<Ville> villeFound = villeDepot.findById(villeId);

		if (villeFound.isPresent()){
			retourArticle = villeFound.get().getArticles();
		} else {
			throw new NotFoundException();
		}
		return retourArticle;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Méthode qui ajoute un article à la liste
	 * @param dataArticle: correspond aux données de l'article passées dans le Json
	 * @return le nouvel article sauvegardé
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Article ajouterArticle(@RequestBody Article dataArticle) 
	{
		return articleDepot.saveAndFlush(dataArticle);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Méthode qui supprime un article de la BDD
	 * @param articleId: précisé dans l'url (ex : /articles/2)
	 * @throws Exception l'article n'existe pas
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
