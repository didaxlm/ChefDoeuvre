package fr.didier.giveapp.app.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

	public Photo(String urlPhoto, Article article)
	{
		this.urlPhoto = urlPhoto;
		this.article = article;
	}
}
