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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

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
     * TODO : séparer les cors csrf .... collé en commentaire à la fin de cette page
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.cors()
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/","/users","/users/compte").permitAll()//mettre les endpoint exemple : /api/user/sign-in
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                /**
                 * TODO : modifier le dernier antMatchers
                 */
                .antMatchers("/**").permitAll()//mettre les endpoint exemple : /api/user/sign-up
                //Disallow everything else...
                .anyRequest().authenticated();
        //Apply Jwt
        http.addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().disable();
    }

    /**
     *TODO : ressources n'existe pas
     */
    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/resources/**");
    }

    /**
     *
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));

        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));

        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
/////////////////////////////////////////////////////////////
//@Override
//protected void configure(HttpSecurity http) throws Exception {
//
//    http.cors();
//
//    // Disable CSRF (cross site request forgery as our token will be stored in session storage)
//    http.csrf().disable();
//
//    // No session will be created or used by spring security
//    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//    // Entry points
//    http.authorizeRequests()//
//            .antMatchers("/api/sign-in", "/api/sign-up").permitAll()//
//            .antMatchers("/api/init").permitAll()//
//            .antMatchers(HttpMethod.GET, "/api/posts").permitAll()//
//            .antMatchers("/h2-console/**").permitAll()
//            .antMatchers("/v2/api-docs", "/webjars/**", "/swagger-resources/**", "/configuration/**", "/swagger-ui.html/**").permitAll()
////                .antMatchers("/").permitAll() // TODO ajouter une page racine
////                .antMatchers("/csrf").permitAll()
//
//            // Disallow everything else...
//            .anyRequest().authenticated();
//
//    // Apply JWT
//    http.addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
//
//    http.headers().frameOptions().disable();
//
//}