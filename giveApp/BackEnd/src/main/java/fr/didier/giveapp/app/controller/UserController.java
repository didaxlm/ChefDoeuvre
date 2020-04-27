package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.exceptions.NotFoundException;
import fr.didier.giveapp.app.model.JsonWebToken;
import fr.didier.giveapp.app.model.User;
import fr.didier.giveapp.app.repository.UserRepository;
import fr.didier.giveapp.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController 
{
	@Autowired
	private UserRepository userDepot;

	@Autowired
	private UserService userService;

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Méthode qui affiche la liste des utilisateurs
	 * @return toute la liste
	 */
	@GetMapping
	public List<User> afficherListeUser() 
	{
		return userDepot.findAll();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Méthode qui ajoute un utilisateur dans la BDD
	 * @param user: correspond aux données du user passées dans le Json
	 * @return
	 */
	@PostMapping("/sign-up")
	public ResponseEntity<User> signUp(@RequestBody User user)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.signUp(user));
	}

	/** TODO affiner le commentaire
	 * Méthode qui identifie un utilisateur
	 * @param user
	 * @return
	 */
	@PostMapping("/sign-in")
	public ResponseEntity<JsonWebToken> signIn(@RequestBody User user)
	{
		System.out.println("dodo");
		return ResponseEntity.ok(new JsonWebToken(userService.signIn(user.getPseudo(), user.getMotDePasse())));
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * supprime un utilisateur de la BDD
	 * @param userId: précisé dans l'url (ex : /users/2)
	 * @throws Exception l'utilisateur n'existe pas
	 */
	@DeleteMapping("{userId}")
	public void	supprimerUser(@PathVariable int userId) throws NotFoundException {
		if (userDepot.existsById(userId)){
			userDepot.deleteById(userId);
		} else {
			throw new NotFoundException();
		}
	}
}
