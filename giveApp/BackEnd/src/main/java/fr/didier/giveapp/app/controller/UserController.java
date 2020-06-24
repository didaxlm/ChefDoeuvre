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
	 * @param newUser: correspond aux données du user passées dans le Json
	 * @return le user créé sous forme d'une hash
	 */
	@PostMapping("/sign-up")
	public ResponseEntity<User> ajouterUser(@RequestBody User newUser)
	{
		newUser.setDateInscription(LocalDate.now());
		newUser = userService.signUp(newUser);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}

	/**
	 * Méthode qui identifie un utilisateur
	 * @param user
	 * @return le jwt
	 */
	@PostMapping("/sign-in")
	public ResponseEntity<JsonWebToken> signIn(@RequestBody User user)
	{
		return ResponseEntity.ok(new JsonWebToken(userService.signIn(user.getPseudo(), user.getMotDePasse())));
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Méthode qui permet de modifier les données d'un utilisateur
	 * @param userData : les données de l'utilisateur
	 * @return l'utilisateur modifié sous forme d'une hash
	 */
	@PutMapping
	public ResponseEntity<User> modifierUser(@RequestBody User userData)
	{
		Optional<User> userAmodifier = userDepot.findById(userData.getId());
		if (userAmodifier.isPresent())
		{
			userData = userService.signUp(userData);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(userData);
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
