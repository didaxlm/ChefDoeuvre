							package fr.didier.giveapp.app.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int id;
	private int typeUser;
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
	@OneToMany(mappedBy = "user")
	private Set<Article> articles = new HashSet();

    public User(String nom, String prenom, int typeUser, String motDePasse, String pseudo, String adresse, String mail, String codePostal, LocalDate dateInscription)
	{
    	this.nom = nom;
    	this.prenom = prenom;
    	this.typeUser = typeUser;
    	this.motDePasse = motDePasse;
    	this.pseudo = pseudo;
    	this.adresse = adresse;
    	this.mail = mail;
    	this.codePostal = codePostal;
    	this.dateInscription = dateInscription;
    }

	public void addUser(Article article)
	{
		articles.add(article);
	}
}
