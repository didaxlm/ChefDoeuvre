package fr.didier.giveapp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.model.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> 
{
	Optional<Article> findByTypeCategorie(String typeCategorie);
}
