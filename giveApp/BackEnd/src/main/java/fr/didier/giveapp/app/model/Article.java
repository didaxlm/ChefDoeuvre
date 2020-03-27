package fr.didier.giveapp.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Article 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incr�ment
	private int id;
	private int quantiteArticle;
	private String nomArticle;
	private String etatArticle;
	private Date dateDepot;
	
	// plusieurs objets ont un utilisateur
	@ManyToOne(cascade = CascadeType.PERSIST) 
	@JoinColumn( name="user", referencedColumnName = "id")
	private User user;
	
	@ManyToOne // plusieurs objets sont associ�es � une ville
	@JoinColumn( name="ville", referencedColumnName = "id")
	private Ville ville;
	
	@ManyToOne // plusieurs objets appartiennent � une cat�gorie
	@JoinColumn( name="categorie", referencedColumnName = "id")
	private Categorie categorie;
	
	@OneToMany(mappedBy = "nomArticle") // un objet d�tient plusieurs photos
	private List<Photo> photo; 
	
	public Article(String nomArticle) 
	{
		this.nomArticle = nomArticle;
	}
	
	// methode qui g�n�re la date lors de l'appel de l'objet
	public void dateInit() {
		this.dateDepot = new Date();
	}
}
