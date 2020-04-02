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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dateDepot;
	
	// plusieurs objets ont un utilisateur
	@ManyToOne() 
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn( name="user", referencedColumnName = "id")
	private User user;
	
	@ManyToOne // plusieurs objets sont associ�es � une ville
	@JoinColumn( name="ville", referencedColumnName = "id")
	private Ville ville;
	
	@ManyToOne // plusieurs objets appartiennent � une cat�gorie
	@JoinColumn( name="categorie", referencedColumnName = "id")
	private Categorie categorie;
	
	@JsonBackReference // �vite les boucles d'appel dans le json
	// un objet d�tient plusieurs photos
	@OneToMany(mappedBy = "article",
			   cascade = { CascadeType.REFRESH, CascadeType.REMOVE }) 
	private List<Photo> photo; 
	
	// methode qui g�n�re la date lors de l'appel de l'objet
	public void dateInit() {
		this.dateDepot = new Date();
	}
}
