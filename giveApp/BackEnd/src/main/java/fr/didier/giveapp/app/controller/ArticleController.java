package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.exceptions.NotFoundException;
import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.model.Categorie;
import fr.didier.giveapp.app.model.User;
import fr.didier.giveapp.app.repository.ArticleRepository;
import fr.didier.giveapp.app.repository.CategorieRepository;
import fr.didier.giveapp.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequestMapping("/articles")
@RestController
public class ArticleController
{
	@Autowired
	private ArticleRepository articleDepot;

	@Autowired
	private CategorieRepository categorieDepot;

	@Autowired
	private UserRepository userDepot;

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
	 * Méthode qui récupère un article en particulier en fonction de l'id de l'article
	 * @param articleId : précisé dans l'url (ex : articles/id/1)
	 * @return l'article précisé
	 */
	@GetMapping("id/{articleId}")
	public Optional<Article> afficherArticle(@PathVariable int articleId)
	{
		return articleDepot.findById(articleId);
	}
	/**
	 * Méthode qui affiche une liste d'articles en fonction de la localisation
	 * @param ville : précisé dans l'url (ex: articles/nantes)
	 * @return une liste d'articles
	 */
	@RequestMapping(value = "{ville}",method = RequestMethod.GET)
	public List<Article> afficherArticlesByLieu(@PathVariable String ville)
	{
		return articleDepot.findByLieuArticle(ville);
	}
	/**
	 * Méthode qui affiche une liste d'articles en fonction de l'id de la catégorie
	 * @param categorieId : précisé dans l'url (ex : articles/categorie/1)
	 * @return le ou les articles de la catégorie
	 * @throws Exception si la catégorie de l'article n'existe pas
	 */
	@GetMapping("categorie/{categorieId}")
	public Set<Article> afficherArticlesByCategorie(@PathVariable int categorieId) throws Exception
	{
		Set<Article> retourArticle;
		Optional<Categorie> categorieFound = categorieDepot.findById(categorieId);

		if (categorieFound.isPresent())
		{
			retourArticle = categorieFound.get().getArticles();
		} else {
			throw new NotFoundException();
		}
		return retourArticle;
	}
	/**
	 * Méthode qui affiche une liste d'articles en fonction de l'id de l'utilisateur
	 * @param userId : précisé dans l'url (ex : articles/user/2)
	 * @return le ou les articles associé(s) à l'utilisateur
	 * @throws Exception si l'utilisateur n'existe pas
	 */
	@GetMapping("user/{userId}")
	public Set<Article> afficherArticlesByUser(@PathVariable int userId) throws Exception
	{
		Set<Article> retourArticle;
		Optional<User> userFound = userDepot.findById(userId);

		if (userFound.isPresent())
		{
			retourArticle = userFound.get().getArticles();
		} else {
			throw new NotFoundException();
		}
		return retourArticle;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Méthode qui ajoute un article à la liste
	 * @param dataArticle: correspond aux données de l'article passées dans le Json
	 * @return le nouvel article sauvegardé avec la date du jour
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Article ajouterArticle(@RequestBody Article dataArticle)
	{
		dataArticle.setDateDepot(LocalDate.now());
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
