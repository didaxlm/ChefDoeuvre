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
public class Ville 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int idVille;
	
	private String nomVille;

	public Ville(int idVille, String nomVille) 
	{
		this.idVille = idVille;
		this.nomVille = nomVille;
	}
}
