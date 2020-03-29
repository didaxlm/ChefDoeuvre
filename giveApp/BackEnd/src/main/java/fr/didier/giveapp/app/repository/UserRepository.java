package fr.didier.giveapp.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.didier.giveapp.app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	Optional<User> findByPseudo(User pseudo);
}
