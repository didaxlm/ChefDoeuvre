package fr.didier.giveapp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Faq 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int idFaq;
	
	private String question;
	private String reponse;
	
	public Faq(int idFaq, String question, String reponse) {
		super();
		this.idFaq = idFaq;
		this.question = question;
		this.reponse = reponse;
	}
}
