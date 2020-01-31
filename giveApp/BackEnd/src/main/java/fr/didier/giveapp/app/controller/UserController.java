package fr.didier.giveapp.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController 
{

	@GetMapping
	public String get() 
	{
		return "Bonjours";
	}
}
