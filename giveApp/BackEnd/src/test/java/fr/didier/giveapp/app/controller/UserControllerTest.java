package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

public class UserControllerTest
{
    @Autowired
    private MockMvc mockMvc;
}
