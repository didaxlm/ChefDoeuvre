package fr.didier.giveapp.app.model;

import java.util.Date;
import java.util.List;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int id;
	private int quantiteArticle;
	private String article;
	private String etatObjet;
	private Date dateDepot;
	@ManyToOne // plusieurs objets ont un utilisateur
	@JoinColumn( name="user", referencedColumnName = "id")
	private User user;
	@ManyToOne // plusieurs objets sont associées à une ville
	private Ville ville;
	@ManyToOne // plusieurs objets appartiennent à une catégorie
	private Categorie categorie;
	@OneToMany // un objet détient plusieurs photos
	@JoinColumn( name="id")
	private List<Photo> photo; 
	
	public Article(String article) 
	{
		this.article = article;
	}
	
	// methode qui génère la date lors de l'appel de l'objet
	public void dateInit() {
		this.dateDepot = new Date();
	}
}
