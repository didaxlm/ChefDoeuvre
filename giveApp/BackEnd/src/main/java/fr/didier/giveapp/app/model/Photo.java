package fr.didier.giveapp.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Photo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incr�ment
	private int id;	
	private String urlPhoto;
	
	// plusieurs photos d�tiennent un objet
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn( name="article", referencedColumnName = "id")
	private Article article;
	

}
