package fr.didier.giveapp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.didier.giveapp.app.model.Faq;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Integer>{}
