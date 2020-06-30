package fr.didier.giveapp.app.services;

import fr.didier.giveapp.app.model.User;
import fr.didier.giveapp.app.repository.UserRepository;
import fr.didier.giveapp.app.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService
{
    @Autowired
    private UserRepository userDepot;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException
    {
        Optional<User> user = userDepot.findByPseudo(pseudo);
        if (user.isPresent())
        {
        return user.get();
        } else {
            throw new UsernameNotFoundException("utilisateur introuvable");
        }
    }

    public String signIn(String pseudo, String motDePasse) throws BadCredentialsException
    {
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(pseudo, motDePasse));
            return jwtTokenProvider.createToken(userDepot.findByPseudo(pseudo).get());
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("login invalide");
        }
    }

    public User signUp(User user)
    {
        user.setMotDePasse(passwordEncoder.encode(user.getMotDePasse()));
        return userDepot.saveAndFlush(user);
    }

    public boolean isPseudoExist(String pseudo){
        return userDepot.existsByPseudo(pseudo);
    }
}
