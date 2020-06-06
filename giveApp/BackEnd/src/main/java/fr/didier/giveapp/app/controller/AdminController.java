package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.model.User;
import fr.didier.giveapp.app.repository.UserRepository;
import fr.didier.giveapp.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    UserRepository userDepot;

    @Autowired
    private UserService userService;

    /**
     * Méthode qui affiche la liste des utilisateurs
     * @return toute la liste
     */
    @GetMapping("/users")
    public List<User> afficherListeUser()
    {
        return userDepot.findAll();
    }
    /**
     * Méthode qui permet de modifier les données d'un utilisateur
     * @param userData : les données de l'utilisateur
     * @return l'utilisateur modifié sous forme d'une hash
     */
    @PutMapping("/user")
    public ResponseEntity<User> modifierUser(@RequestBody User userData)
    {
        Optional<User> userAmodifier = userDepot.findById(userData.getId());
        if (userAmodifier.isPresent())
        {
            userData = userService.signUp(userData);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(userData);
    }
}
