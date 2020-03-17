package fr.didier.giveapp.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Objet 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int idObjet;
	private int quantiteObjet;
	private String nomObjet;
	private String etatObjet;
	private Date dateDepot;
	
	public Objet(int idObjet, int quantiteObjet, String nomObjet, String etatObjet, Date dateDepot) 
	{
		super();
		this.idObjet = idObjet;
		this.quantiteObjet = quantiteObjet;
		this.nomObjet = nomObjet;
		this.etatObjet = etatObjet;
		this.dateDepot = dateDepot;
	}
}
