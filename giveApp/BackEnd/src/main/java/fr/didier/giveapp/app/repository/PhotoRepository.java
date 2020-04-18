package fr.didier.giveapp.app.repository;

import fr.didier.giveapp.app.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer>{}
