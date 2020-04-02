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

import fr.didier.giveapp.app.model.Faq;
import fr.didier.giveapp.app.model.User;
import fr.didier.giveapp.app.repository.FaqRepository;

@RequestMapping("/faq")
@RestController
public class FaqController 
{
	@Autowired
	private FaqRepository faqDepot;
	
	//affiche la liste des questions et des r�ponses
	@GetMapping
	public List<Faq> afficherListeFaq() 
	{
		return faqDepot.findAll();
	}
	
	/*
	 * ajoute une question ou une r�ponse � la FaQ
	 * @param faqQuestion: correspond � la question pass�es dans le Json
	 * @return
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Faq ajoutQuestion(@RequestBody Faq faqQuestion) 
	{
		return faqDepot.saveAndFlush(faqQuestion);
	}
	
	/*
	 * supprime une question de la FaQ
	 * @param faqQuestion: correspond � la question pass�es dans le json
	 * @return
	 */
	@DeleteMapping 
	public void supprimerQuestion(@RequestBody Faq faqQuestion) 
	{
		faqDepot.delete(faqQuestion);
	}
}
