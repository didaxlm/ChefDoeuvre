package fr.didier.giveapp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.model.User;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>
{
	Optional<Article> findByArticle(String article);
}
