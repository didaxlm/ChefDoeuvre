package fr.didier.giveapp.app.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Faq 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int id;
	
	private String question;
	private String reponse;

	public Faq(String question, String reponse) {
	}
}
