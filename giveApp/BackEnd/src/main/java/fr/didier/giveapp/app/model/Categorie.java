package fr.didier.giveapp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Categorie 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategorie;
	
	private String typeCategorie;

	public Categorie(int idCategorie, String typeCategorie) 
	{
		super();
		this.idCategorie = idCategorie;
		this.typeCategorie = typeCategorie;
	}
}
