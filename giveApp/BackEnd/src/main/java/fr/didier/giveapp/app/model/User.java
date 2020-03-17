package fr.didier.giveapp.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser, typeUser;
	private String userNom ;
	private String userPrenom;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //permet de ne pas afficher le password dans le json
	private String motDePasse;
	
	private String mail;
	private String adresse;
	private String codePostal;
	private String pseudo;
	private Date dateInscription;
	
	public User(int idUser, int typeUser, String userNom, String userPrenom, String motDePasse, String mail,
			String adresse, String codePostal, String pseudo, Date dateInscription) 
	{
		super();
		this.idUser = idUser;
		this.typeUser = typeUser;
		this.userNom = userNom;
		this.userPrenom = userPrenom;
		this.motDePasse = motDePasse;
		this.mail = mail;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.pseudo = pseudo;
		this.dateInscription = dateInscription;
	}
	
}
