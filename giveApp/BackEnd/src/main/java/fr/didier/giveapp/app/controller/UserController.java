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

import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.model.User;
import fr.didier.giveapp.app.repository.UserRepository;

@RequestMapping("/users")
@RestController
public class UserController 
{
	@Autowired
	private UserRepository userDepot;
	
	//affiche la liste des utilisateurs
	@GetMapping
	public List<User> afficherListeUser() 
	{
		return userDepot.findAll();
	}
	
	/*
	 * ajoute un utilisateur dans la BDD
	 * @param userData: correspond aux données du user passées dans le Json
	 * @return
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public User ajouterUser(@RequestBody User userData) 
	{
		return userDepot.saveAndFlush(userData);
	}
	
	/*
	 * supprime un utilisateur de la BDD
	 * @param id: correspond aux données du user passées dans le json
	 * @return
	 */
	@DeleteMapping
	public String supprimerUser(@RequestBody User userData) 
	{
		userDepot.delete(userData);
		return "utilisateur supprimé";
	}
}
