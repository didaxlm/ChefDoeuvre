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
public class Faq 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int idFaq;
	
	private String question;
	private String reponse;
	
	public Faq() {}
	
	public Faq(int idFaq, String question, String reponse) 
	{
		this.idFaq = idFaq;
		this.question = question;
		this.reponse = reponse;
	}
}
