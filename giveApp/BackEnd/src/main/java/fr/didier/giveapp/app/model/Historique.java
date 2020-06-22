package fr.didier.giveapp.app.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Historique 
{
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateTransaction;
	@Id
	private int id;

	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate dateDepot;

	private int quantiteArticle;
	private String nomArticle;
	private String etatArticle;
	private String lieuArticle;


	public Historique(LocalDate dateTransaction) {
	}
}
