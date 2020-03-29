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

import fr.didier.giveapp.app.model.Categorie;
import fr.didier.giveapp.app.model.Ville;
import fr.didier.giveapp.app.repository.CategorieRepository;

@RestController
@RequestMapping("/categories")
public class CategorieController 
{
	@Autowired
	private CategorieRepository categorieDepot;
	
	//affiche la liste des villes
	@GetMapping
	public List<Categorie> afficherListeCategorie()
	{
		return categorieDepot.findAll();
	}
	
	/*
	 * ajoute une catégorie à la liste
	 * @param categorieData: correspond aux données de la catégorie passées dans le Json
	 * @return
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Categorie ajouterCategorie(@RequestBody Categorie categorieData) 
	{
		return categorieDepot.saveAndFlush(categorieData);
	}
	
	/*
	 * supprime une catégorie de la BDD
	 * @param categorieData: correspond aux données de la catégorie passées dans le Json
	 * @return
	 */
	@DeleteMapping
	public String supprimerCategorie(@RequestBody Categorie categorieData) 
	{
		categorieDepot.delete(categorieData);
		return "la catégorie a été supprimée";
	}
}
