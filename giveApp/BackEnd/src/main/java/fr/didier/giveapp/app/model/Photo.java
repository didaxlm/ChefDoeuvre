package fr.didier.giveapp.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Photo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int id;	
	private String urlPhoto;
	
	// plusieurs photos détiennent un objet
	@ManyToOne
	@JoinColumn( name="article", referencedColumnName = "id")
	private Article article;

	public Photo(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public Photo(String urlPhoto, Article article)
	{
		this.urlPhoto = urlPhoto;
		this.article = article;
	}
}
