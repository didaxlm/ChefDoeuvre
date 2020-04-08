package fr.didier.giveapp.app.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	
	@JsonBackReference// �vite les boucles d'appel dans le json
	// une ville a plusieurs objets
	@OneToMany(mappedBy = "ville", cascade = CascadeType.MERGE)
	private Set<Article> articles = new HashSet();

	public Ville(String nomVille)
	{
		this.nomVille = nomVille;
	}
}
