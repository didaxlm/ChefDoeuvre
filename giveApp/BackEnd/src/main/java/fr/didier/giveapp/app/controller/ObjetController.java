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

import fr.didier.giveapp.app.model.Objet;
import fr.didier.giveapp.app.repository.ObjetRepository;

@RequestMapping("/objets")
@RestController
public class ObjetController 
{
	@Autowired
	private ObjetRepository objetDepot;
	
	//affiche la liste des objets
	@GetMapping
	public List<Objet> afficherListeObjet() 
	{
		return objetDepot.findAll();
	}
	
	/*
	 * ajoute un objet à la liste
	 * @param nomObjet: correspond au nom de l'objet passé dans le Json
	 * @return
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Objet createObjet(@RequestBody Objet nomObjet) 
	{
		return objetDepot.saveAndFlush(nomObjet);
	}
}
