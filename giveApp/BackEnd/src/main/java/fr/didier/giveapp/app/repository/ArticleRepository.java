package fr.didier.giveapp.app.repository;

import fr.didier.giveapp.app.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>{}
