package fr.didier.giveapp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.didier.giveapp.app.model.Objet;
import fr.didier.giveapp.app.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer>
{
	Optional<Objet> findByNomVille(String nomVille);
}
