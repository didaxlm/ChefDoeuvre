package fr.didier.giveapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.didier.giveapp.app.model.User;
import fr.didier.giveapp.app.repository.UserRepository;

@RequestMapping("/users")
@RestController
public class UserController 
{
	@Autowired
	private UserRepository userDepot;
	
	@GetMapping
	public List<User> afficherListeUser() 
	{
		List<User> tousLesUsers = userDepot.findAll();
		return tousLesUsers;
	}
	
	/*@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public User create(@RequestBody User userData) 
	{
		return userData;
	}*/
}
