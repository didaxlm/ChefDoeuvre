package fr.didier.giveapp.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Categorie 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int id;	
	private String typeCategorie;
	
	@JsonBackReference// évite les boucles d'appel dans le json
	// une catégorie a plusieurs objets
	@OneToMany(mappedBy = "categorie",
			   cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Article> article;

}
