package fr.didier.giveapp.app.repository;

import fr.didier.giveapp.app.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>
{
    Optional<Article> findByNomArticle(String nomArticle);
    //Optional<Article> findByQuantiteArticle(int quantiteArticle);
}
