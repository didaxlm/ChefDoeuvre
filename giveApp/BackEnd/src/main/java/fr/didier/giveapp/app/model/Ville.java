package fr.didier.giveapp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ville 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incr�ment
	private int id;
	
	private String nomVille;	
}
