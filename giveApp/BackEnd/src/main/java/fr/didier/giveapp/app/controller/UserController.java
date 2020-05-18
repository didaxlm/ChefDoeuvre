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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
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
	/**
	 * Méthode qui récupère un utilisateur en particulier en fonction de son id
	 * @param userId : précisé dans l'url (ex : users/id/1)
	 * @return le user précisé
	 */
	@GetMapping("id/{userId}")
	public Optional<User> afficherUser(@PathVariable int userId)
	{
		return userDepot.findById(userId);
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
		user.setDateInscription(LocalDate.now());
		System.out.println(user);
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
