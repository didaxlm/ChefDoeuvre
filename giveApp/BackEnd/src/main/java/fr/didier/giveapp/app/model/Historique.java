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
public class Historique 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int id;
	
	private Date dateTransaction;

	public Historique(int id, Date dateTransaction) 
	{
		this.id = id;
		this.dateTransaction = dateTransaction;
	}
}
