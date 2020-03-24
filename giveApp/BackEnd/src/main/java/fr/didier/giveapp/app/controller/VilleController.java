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
		List<Ville> retourListeVille = villeDepot.findAll();
		return retourListeVille;
	}
	
	/*
	 * ajoute une ville � la liste
	 * @param nomVille: correspond au nom de la ville pass�e dans le Json
	 * @return
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Ville ajouterVille(@RequestBody Ville nomVille) 
	{
		return villeDepot.saveAndFlush(nomVille);
	}
	/*
	 * supprime une ville de la BDD
	 * @param idVille: correspond � l'id de la ville pass� dans le Json
	 * @return
	 */
	@DeleteMapping
	public String supprimerVille(@RequestBody Ville idVille) 
	{
		villeDepot.delete(idVille);
		return "la ville a �t� supprim�e";
	}
}
