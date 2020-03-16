package src.main.java.fr.didier.giveapp.app.model;

@Getter
@Setter
@Entity
public class Objet 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idObjet;
	private int quantiteObjet;
	private String nomObjet;
	private String etatObjet;
	private Date dateDepot;
}
