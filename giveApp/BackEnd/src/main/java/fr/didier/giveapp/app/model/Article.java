package fr.didier.giveapp.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
	private LocalDate dateDepot;
	
	// plusieurs objets ont un utilisateur
	@ManyToOne (fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn( name="user", referencedColumnName = "id")
	private User user;
	
	@ManyToOne (fetch = FetchType.EAGER) // plusieurs objets sont associ�es � une ville
	@JoinColumn( name="ville", referencedColumnName = "id")
	private Ville ville;
	
	@ManyToOne (fetch = FetchType.EAGER)// plusieurs objets appartiennent � une cat�gorie
	@JoinColumn( name="categorie", referencedColumnName = "id")
	private Categorie categorie;
	
	@JsonBackReference // �vite les boucles d'appel dans le json
	// un objet d�tient plusieurs photos
	@OneToMany(mappedBy = "article", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	private Set<Photo> photos = new HashSet();

	public Article(LocalDate dateDepot, String nomArticle, String etatArticle, int quantiteArticle, Categorie categorie, User user, Ville ville)
	{
		this.dateDepot = dateDepot;
		this.nomArticle = nomArticle;
		this.etatArticle = etatArticle;
		this.quantiteArticle = quantiteArticle;
		this.categorie = categorie;
		this.user = user;
		this.ville = ville;
	}
}
