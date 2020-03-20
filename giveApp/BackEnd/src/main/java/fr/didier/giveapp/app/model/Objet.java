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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="OBJET")
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
	@JoinColumn( name="idPhoto", nullable=false, insertable=false, updatable=false)
	private List<Photo> photo; 
	
	public Objet() {}
	
	public Objet(int idObjet, int quantiteObjet, String nomObjet, String etatObjet, Date dateDepot) 
	{
		this.idObjet = idObjet;
		this.quantiteObjet = quantiteObjet;
		this.nomObjet = nomObjet;
		this.etatObjet = etatObjet;
		this.dateDepot = dateDepot;
	}
	
	// methode qui génère la date lors de l'appel de l'objet
	public void dateInit() {
		this.dateDepot = new Date();
	}	
}
