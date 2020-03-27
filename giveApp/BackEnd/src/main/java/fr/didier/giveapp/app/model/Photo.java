package fr.didier.giveapp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Photo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incr�ment
	private int id;	
	private String urlPhoto;
	@ManyToOne // plusieurs photos d�tiennent un objet
	private Article objet;
	

	public Photo(int idPhoto, String urlPhoto) 
	{
		this.id = idPhoto;
		this.urlPhoto = urlPhoto;
	}
}
