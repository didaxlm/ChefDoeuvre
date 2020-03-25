package fr.didier.giveapp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.didier.giveapp.app.model.Faq;
import fr.didier.giveapp.app.repository.FaqRepository;

@RestController
@RequestMapping("/faq")
public class FaqController 
{
	@Autowired
	private FaqRepository faqDepot;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Faq ajoutFaq(@RequestBody Faq faq) 
	{
		faqDepot.saveAndFlush(faq);
		return faq;
	}
}
