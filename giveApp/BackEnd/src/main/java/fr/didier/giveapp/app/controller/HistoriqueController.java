package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.model.Historique;
import fr.didier.giveapp.app.repository.HistoriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/historiques")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HistoriqueController
{
    @Autowired
    private HistoriqueRepository historiqueDepot;

    //affiche la liste des historiques
    @GetMapping
    public List<Historique> afficherHistorique()
    {
        return historiqueDepot.findAll();
    }
}
