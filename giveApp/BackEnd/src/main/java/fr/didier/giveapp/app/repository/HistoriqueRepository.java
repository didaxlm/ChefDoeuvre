package fr.didier.giveapp.app.repository;

import fr.didier.giveapp.app.model.Historique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Integer> {}
