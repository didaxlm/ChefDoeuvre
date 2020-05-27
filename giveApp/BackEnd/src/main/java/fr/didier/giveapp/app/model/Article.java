package fr.didier.giveapp.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

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
	private String lieuArticle;

	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dateDepot;


	@ManyToOne // plusieurs objets ont un utilisateur
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn( name="user", referencedColumnName = "id")
	private User user;

	@ManyToOne // plusieurs objets appartiennent à une catégorie
	@JoinColumn( name="categorie", referencedColumnName = "id")
	private Categorie categorie;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name ="photo", referencedColumnName = "id")
	private Photo photo;
//	@JsonIgnoreProperties("article") // évite les boucles d'appel dans le json
//	@OneToMany(mappedBy = "article", orphanRemoval = true)// un objet détient plusieurs photos
//	private Set<Photo> photos = new HashSet();

	public Article(LocalDate dateDepot, String nomArticle, String etatArticle,String lieuArticle, int quantiteArticle, Categorie categorie, User user, Photo photo)
	{
		this.dateDepot = dateDepot;
		this.nomArticle = nomArticle;
		this.etatArticle = etatArticle;
		this.quantiteArticle = quantiteArticle;
		this.lieuArticle = lieuArticle;
		this.categorie = categorie;
		this.user = user;
		this.photo = photo;
	}
}
//package fr.didier.giveapp.app.model;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//import java.time.LocalDate;
//
//@Getter
//@Setter
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//public class Article
//{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
//	private int id;
//	private int quantiteArticle;
//	private String nomArticle;
//	private String etatArticle;
//	private String lieuArticle;
//
//	@JsonFormat(pattern="dd-MM-yyyy")
//	private LocalDate dateDepot;
//
//
//	@ManyToOne // plusieurs objets ont un utilisateur
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JoinColumn( name="user", referencedColumnName = "id")
//	private User user;
//
//	@ManyToOne // plusieurs objets appartiennent à une catégorie
//	@JoinColumn( name="categorie", referencedColumnName = "id")
//	private Categorie categorie;
//
//	@ManyToOne
//	@JoinColumn( name ="photo", referencedColumnName = "id")
//	private Photo photo;
//
//	public Article(LocalDate dateDepot, String nomArticle, String etatArticle,String lieuArticle, int quantiteArticle, Categorie categorie, User user, Photo photo)
//	{
//		this.dateDepot = dateDepot;
//		this.nomArticle = nomArticle;
//		this.etatArticle = etatArticle;
//		this.lieuArticle = lieuArticle;
//		this.quantiteArticle = quantiteArticle;
//		this.user = user;
//		this.categorie = categorie;
//		this.photo = photo;
//	}
//}
//		@JsonIgnoreProperties("article") // évite les boucles d'appel dans le json
//	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL,orphanRemoval = true)// un objet détient plusieurs photos
//	@JoinColumn( name = "photo", referencedColumnName = "id")
//	private Set<Photo> photos = new HashSet<>();