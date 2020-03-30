package fr.didier.giveapp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.didier.giveapp.app.model.Faq;
import fr.didier.giveapp.app.model.User;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer>
{
	Optional<Faq> findByQuestion(String question);
}
