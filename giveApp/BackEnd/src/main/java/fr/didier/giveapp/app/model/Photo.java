package fr.didier.giveapp.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Photo 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPhoto;
	
	private String urlPhoto;

	public Photo(int idPhoto, String urlPhoto) {
		super();
		this.idPhoto = idPhoto;
		this.urlPhoto = urlPhoto;
	}
}
