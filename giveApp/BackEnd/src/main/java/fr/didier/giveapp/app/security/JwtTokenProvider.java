package fr.didier.giveapp.app.security;

import fr.didier.giveapp.app.services.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider
{
    //on recupere le secret dans le fichier propertie
    @Value("${security.jwt.token.secret:ceciestlacléquipermetdehasherladonnée}")
    private String secretKey;

    //ici met la valeur par defaut
    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds = 3600000; //1h

    @Autowired
    private UserService userService;

    /**
     * cette methode d'initialisation s'execute avant le constructeur
     * elle encode notre code secret en base64 pour la transmission dans le header
     */
    @PostConstruct
    protected void init()
    {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    /**
     * methode qui créer un token :
     * "sub" pour pseudo
     * "auth" pour roles
     * "iat" pour date du jour
     * "exp" pour date du jour + validityTime
     */
    public String createToken(String pseudo, Collection<? extends  GrantedAuthority> roles)
    {
        Claims claims = Jwts.claims().setSubject(pseudo);
        claims.put("auth", roles.stream().map(s -> s.getAuthority()).filter(Objects::nonNull).collect(Collectors.toList()));

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    /**
     * methode qui obtient le pseudo depuis jwt
     * @param token le token utilisé pour l'authentification
     * @return
     */
    public String extractPseudo(String token)
    {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
    /**
     * methode qui retourne
     */
    public Authentication getAuthentication(String token)
    {
        UserDetails userDetails = userService.loadUserByUsername(extractPseudo(token));
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }

    /**
     *
     */
    public String resolveToken(HttpServletRequest req)
    {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer "))
        {
            return bearerToken.substring(7); // si "toto " alors 5
        }
        return null;
    }

    /**
     *
     */
    public boolean validateToken(String token) throws Exception
    { //TODO mettre InvalidJWTException dans package exceptions
        try
        {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new Exception("token invalide");
        }
    }
}
