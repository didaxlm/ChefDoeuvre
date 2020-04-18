package fr.didier.giveapp.app.services;

import fr.didier.giveapp.app.model.User;
import fr.didier.giveapp.app.repository.UserRepository;
import fr.didier.giveapp.app.security.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;



@SpringBootTest
public class UserServiceTest
{
    @Autowired
    UserService userService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @MockBean
    UserRepository userRepository;

    private String usr = "admin";
    private String pwd = "admin";

    @Test
    public void signinUserNotFound(){

    }
}
