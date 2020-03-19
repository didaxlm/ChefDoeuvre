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
public class Photo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int idPhoto;
	
	private String urlPhoto;

	public Photo(int idPhoto, String urlPhoto) 
	{
		this.idPhoto = idPhoto;
		this.urlPhoto = urlPhoto;
	}
}
