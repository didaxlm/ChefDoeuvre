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
 * (En tant que) d�tenteur d'un objet
 * (Je veux) l'ajouter au r�pertoire des objets recyclables
 * (Afin de) proposer au recyclage � d'autres personnes
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
	 * (Alors) la date de signalement est appos�e � l'objet
	 * (Alors) le r�pertoire des objets r�cup�rable est amend�
	 * (Alors) mon porte-feuille d'objet est amend�
	 * (et) les informations fournie sont affich�es
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
