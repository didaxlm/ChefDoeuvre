
package fr.didier.giveapp.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Photo
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
	private int id;
	private String urlPhoto;

	// plusieurs photos détiennent un objet
//	@ManyToOne
//	@JoinColumn( name="article", referencedColumnName = "id")
//	private Article article;
	@JsonIgnoreProperties("photo")
	@OneToMany(mappedBy = "photo")
	private Set<Article> articles = new HashSet<>();

	public Photo(String urlPhoto)
	{
		this.urlPhoto = urlPhoto;
//		this.article = article;
	}
}
//package fr.didier.giveapp.app.model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Photo
//{
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incrément
//	private int id;
//	private String urlPhoto;
//
//	@JsonBackReference
//	@OneToMany(mappedBy = "photo")
//	private Set<Article> articles = new HashSet<>();
//
//	public Photo(String urlPhoto) {
//		this.urlPhoto = urlPhoto;
//	}
//}
