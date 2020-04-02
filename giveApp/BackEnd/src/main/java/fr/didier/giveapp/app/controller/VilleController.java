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

import fr.didier.giveapp.app.model.Ville;
import fr.didier.giveapp.app.repository.VilleRepository;

@RequestMapping("/villes")
@RestController
public class VilleController 
{
	@Autowired
	private VilleRepository villeDepot;
	
	//affiche la liste des villes
	@GetMapping
	public List<Ville> afficherListeVille()
	{
		return villeDepot.findAll();
	}
	
	/*
	 * ajoute une ville à la liste
	 * @param villeData: correspond aux données de la ville passée dans le Json
	 * @return
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ville ajouterVille(@RequestBody Ville villeData) 
	{
		return villeDepot.saveAndFlush(villeData);
	}
	
	/*
	 * supprime une ville de la BDD
	 * @param villeData: correspond aux données de la ville passé dans le Json
	 * @return
	 */
	@DeleteMapping
	public void supprimerVille(@RequestBody Ville villeData) 
	{
		villeDepot.delete(villeData);
	}
}
