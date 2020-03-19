package fr.didier.giveapp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Categorie 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incr�ment
	private int idCategorie;
	
	private String typeCategorie;

	public Categorie() {}
	
	public Categorie(int idCategorie, String typeCategorie) 
	{
		this.idCategorie = idCategorie;
		this.typeCategorie = typeCategorie;
	}
}
