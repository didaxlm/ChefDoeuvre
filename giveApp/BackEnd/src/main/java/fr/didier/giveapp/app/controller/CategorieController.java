package fr.didier.giveapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.didier.giveapp.app.model.Categorie;
import fr.didier.giveapp.app.repository.CategorieRepository;

@RestController
@RequestMapping("/categories")
public class CategorieController 
{
	@Autowired
	private CategorieRepository categorieDepot;
	
	@GetMapping
	public List<Categorie> afficherListeCategorie()
	{
		List<Categorie> allCategorie = categorieDepot.findAll();
		return allCategorie;
	}
}
