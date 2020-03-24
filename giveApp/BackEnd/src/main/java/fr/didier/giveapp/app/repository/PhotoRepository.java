package fr.didier.giveapp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.didier.giveapp.app.model.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {}
