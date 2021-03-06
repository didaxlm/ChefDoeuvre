package fr.didier.giveapp.app.repository;

import fr.didier.giveapp.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findByPseudo (String pseudo);
    Boolean existsByPseudo (String pseudo);
}
