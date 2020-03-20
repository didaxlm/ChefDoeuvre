package fr.didier.giveapp.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.didier.giveapp.app.model.User;

@RestController
public class UserController 
{
	@GetMapping
	public String get() 
	{
		return "Bonjour";
	}
	
	/*@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public User create(@RequestBody User userData) 
	{
		return userData;
	}*/
}
