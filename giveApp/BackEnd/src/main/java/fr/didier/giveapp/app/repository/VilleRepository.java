package fr.didier.giveapp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer>
{
	Optional<Article> findByNomVille(String nomVille);
}
