package fr.didier.giveapp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.didier.giveapp.app.model.Objet;
import fr.didier.giveapp.app.model.User;

@Repository
public interface ObjetRepository extends JpaRepository<Objet, Integer>
{
	Optional<Objet> findByNomObjet(String nomObjet);
}
