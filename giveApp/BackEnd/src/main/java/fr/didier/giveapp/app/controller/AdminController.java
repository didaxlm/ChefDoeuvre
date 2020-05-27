package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.model.User;
import fr.didier.giveapp.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    UserRepository userDepot;

    @GetMapping("/users")
    public List<User> afficherListeUser()
    {
        return userDepot.findAll();
    }
}
