package src.main.java.fr.didier.giveapp.app.model;

@Getter
@Setter
@Entity
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser, typeUser;
	private String userNom ;
	private String userPrenom;
	
	@JsonProperty(acces = JsonProperty.Access.WRITE_ONLY) //permet de ne pas afficher le password dans le json
	private String motDePasse;
	
	private String mail;
	private String codePostal;
	private String pseudo;
	private Date dateInscription;
	
}
