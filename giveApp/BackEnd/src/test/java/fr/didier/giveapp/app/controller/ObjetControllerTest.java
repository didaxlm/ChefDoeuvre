package fr.didier.giveapp.app.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import fr.didier.giveapp.app.model.Objet;
import fr.didier.giveapp.app.repository.ObjetRepository;

/**
 * (En tant que) détenteur d'un objet
 * (Je veux) l'ajouter au répertoire des objets recyclables
 * (Afin de) proposer au recyclage à d'autres personnes
 */
class ObjetControllerTest extends ObjetController
{

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@MockBean
	ObjetRepository objetRepository;
	
	/**
	 * (Lorsque) je signale le don de l'objet A
	 * (Alors) le statut de l'objet est "disponible"
	 * (Alors) la date de signalement est apposée à l'objet
	 * (Alors) le répertoire des objets récupérable est amendé
	 * (Alors) mon porte-feuille d'objet est amendé
	 * (et) les informations fournie sont affichées
	 */
	@Test
	public void testObjetController() 
	{
		Objet objet = new Objet();
		objet.setEtatObjet("Disponible");
		//objet.dateInit
		
		//when(this.objetRepository.findById(7)).thenReturn()
	}

}
