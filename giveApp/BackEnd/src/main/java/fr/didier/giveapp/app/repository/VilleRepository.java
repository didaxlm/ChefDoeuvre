package fr.didier.giveapp.app.repository;

import fr.didier.giveapp.app.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VilleRepository extends JpaRepository<Ville, Integer>
{
	Optional<Ville> findByNomVille(String nomVille);
}
