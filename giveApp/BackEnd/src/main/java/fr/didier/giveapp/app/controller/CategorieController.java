package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.model.Categorie;
import fr.didier.giveapp.app.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200")
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
	public void supprimerCategorie(@RequestBody Categorie categorieData) 
	{
		categorieDepot.delete(categorieData);
	}
}
