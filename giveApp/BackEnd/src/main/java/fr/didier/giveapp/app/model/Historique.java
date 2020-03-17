package fr.didier.giveapp.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Historique 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int idHistorique;
	
	private Date dateTransaction;

	public Historique(int idHistorique, Date dateTransaction) {
		super();
		this.idHistorique = idHistorique;
		this.dateTransaction = dateTransaction;
	}
}
