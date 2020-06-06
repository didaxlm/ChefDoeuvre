package fr.didier.giveapp.app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Categorie
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int id;	
	private String typeCategorie;
	
	@JsonBackReference// évite les boucles d'appel dans le json
	@OneToMany(mappedBy = "categorie") // une catégorie a plusieurs objets
	private Set<Article> articles = new HashSet();

	public Categorie(String typeCategorie) {
		this.typeCategorie = typeCategorie;
	}
}
