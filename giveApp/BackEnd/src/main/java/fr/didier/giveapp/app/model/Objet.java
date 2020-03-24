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
public class Objet 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int idObjet;
	private int quantiteObjet;
	private String nomObjet;
	private String etatObjet;
	private Date dateDepot;
	@ManyToOne // plusieurs objets ont un utilisateur
	private User user;
	@ManyToOne // plusieurs objets sont associées à une ville
	private Ville ville;
	@ManyToOne // plusieurs objets appartiennent à une catégorie
	private Categorie categorie;
	@OneToMany // un objet détient plusieurs photos
	@JoinColumn( name="idPhoto", nullable=false, insertable=false, updatable=false )
	private List<Photo> photo; 
	
	public Objet(String nomObjet) 
	{
		this.nomObjet = nomObjet;
	}
	
	// methode qui génère la date lors de l'appel de l'objet
	public void dateInit() {
		this.dateDepot = new Date();
	}
}
