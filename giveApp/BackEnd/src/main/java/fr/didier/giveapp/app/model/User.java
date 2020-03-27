package fr.didier.giveapp.app.model;

import java.util.Date;
import java.util.List;

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
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateInscription;
	
	@JsonBackReference // évite les boucles d'appel dans le json
	// un utilisateur a plusieurs objets
	@OneToMany(mappedBy = "user",
			   cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List <Article> article;
	
	public User(int id, int typeUser, String nom, String prenom, String motDePasse, String mail,
			String adresse, String codePostal, String pseudo, Date dateInscription) 
	{
		this.id = id;
		this.typeUser = typeUser;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
		this.mail = mail;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.pseudo = pseudo;
		this.dateInscription = dateInscription;
	}	
}
