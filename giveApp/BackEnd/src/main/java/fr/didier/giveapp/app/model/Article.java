package fr.didier.giveapp.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int id;
	private int quantiteArticle;
	private String nomArticle;
	private String etatArticle;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dateDepot;
	

	@ManyToOne // plusieurs objets ont un utilisateur
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn( name="user", referencedColumnName = "id")
	private User user;
	
	@ManyToOne  // plusieurs objets sont associées à une ville
	@JoinColumn( name="ville", referencedColumnName = "id")
	private Ville ville;
	
	@ManyToOne // plusieurs objets appartiennent à une catégorie
	@JoinColumn( name="categorie", referencedColumnName = "id")
	private Categorie categorie;
	
	@JsonBackReference // évite les boucles d'appel dans le json
	// un objet détient plusieurs photos
	@OneToMany(mappedBy = "article", orphanRemoval = true)
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
