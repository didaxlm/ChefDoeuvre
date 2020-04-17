package fr.didier.giveapp.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import fr.didier.giveapp.app.model.Ville;
import fr.didier.giveapp.app.repository.VilleRepository;

@RequestMapping("/villes")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

}
