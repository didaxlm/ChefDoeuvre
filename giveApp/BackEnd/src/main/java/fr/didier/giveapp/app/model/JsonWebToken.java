package fr.didier.giveapp.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JsonWebToken
{
    private final String access_token;
}
