package fr.didier.giveapp.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }

    /**
     * Méthode qui configure les requètes http
     * @param http paramètres des requètes
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //Disable car le token est stocké dans le session storage
        http.csrf().disable();
        //Aucune session ne sera créée ou utilisée par spring security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //Points d'entrée
        http.authorizeRequests()
                .antMatchers("/h2-console/**").hasAnyAuthority("ADMIN")
                .antMatchers("/","/faq/").permitAll()
                .antMatchers("/users/sign-in","/users/sign-up","/connexion").permitAll()
                .antMatchers("/articles","/articles/**","/categories/**","/photos/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                //Refuser tout le reste si non authentifié
                .anyRequest().authenticated();
        //Apply Jwt
        http.addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/resources/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
