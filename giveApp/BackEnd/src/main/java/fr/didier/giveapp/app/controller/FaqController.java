package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.model.Faq;
import fr.didier.giveapp.app.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/faq")
@RestController
public class FaqController
{
	@Autowired
	private FaqRepository faqDepot;

	/**
	 * Affiche la liste complète de la FaQ
	 */
	@GetMapping
	public List<Faq> afficherListeFaq() 
	{
		return faqDepot.findAll();
	}
	
	/*
	 * ajoute une question ou une réponse à la FaQ
	 * @param faqQuestion: correspond à la question passées dans le Json
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
	 * @param faqQuestion: correspond à la question passées dans le json
	 * @return
	 */
	@DeleteMapping 
	public void supprimerQuestion(@RequestBody Faq faqQuestion) 
	{
		faqDepot.delete(faqQuestion);
	}
}
