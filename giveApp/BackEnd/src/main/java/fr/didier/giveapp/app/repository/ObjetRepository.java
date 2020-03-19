package fr.didier.giveapp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.didier.giveapp.app.model.Objet;

@Repository
public interface ObjetRepository extends JpaRepository<Objet, Integer>{}
