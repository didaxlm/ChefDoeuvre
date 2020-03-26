package fr.didier.giveapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.repository.ArticleRepository;

@RequestMapping("/objets")
@RestController
public class ObjetController 
{
	@Autowired
	private ArticleRepository articleDepot;
	
	//affiche la liste des objets
	@GetMapping
	public List<Article> afficherListeArticle() 
	{
		return articleDepot.findAll();
	}
	
	/*
	 * ajoute un objet � la liste
	 * @param nomObjet: correspond au nom de l'objet pass� dans le Json
	 * @return
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Article createObjet(@RequestBody Article article) 
	{
		return articleDepot.saveAndFlush(article);
	}
}
