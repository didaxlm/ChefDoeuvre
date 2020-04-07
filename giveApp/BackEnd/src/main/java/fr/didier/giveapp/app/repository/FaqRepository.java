package fr.didier.giveapp.app.repository;

import fr.didier.giveapp.app.model.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer>
{
	Optional<Faq> findByQuestion(String question);
}
