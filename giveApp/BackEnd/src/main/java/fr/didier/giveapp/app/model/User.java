package fr.didier.giveapp.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int id;

	@JsonIgnore
	private String role = "Utilisateur";

	private String nom ;
	private String prenom;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //permet de ne pas afficher le password dans le json
	private String motDePasse;
	
	private String mail;
	private String adresse;
	private String codePostal;
	private String pseudo;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dateInscription;
	
	@JsonBackReference // évite les boucles d'appel dans le json
	// un utilisateur a plusieurs objets
	@OneToMany(mappedBy = "user", orphanRemoval = true)
	private Set<Article> articles = new HashSet();

    public User(String nom, String prenom, String role, String motDePasse, String pseudo, String adresse, String mail, String codePostal, LocalDate dateInscription)
	{
    	this.nom = nom;
    	this.prenom = prenom;
    	this.role = role;
    	this.motDePasse = motDePasse;
    	this.pseudo = pseudo;
    	this.adresse = adresse;
    	this.mail = mail;
    	this.codePostal = codePostal;
    	this.dateInscription = dateInscription;
    }

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(this.role));
	}

	@Override
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public String getPassword() {
		return motDePasse;
	}

	@Override
	@JsonBackReference
	public String getUsername() {
		return pseudo;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
