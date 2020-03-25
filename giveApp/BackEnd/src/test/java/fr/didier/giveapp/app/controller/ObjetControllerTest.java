package fr.didier.giveapp.app.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import fr.didier.giveapp.app.model.Objet;
import fr.didier.giveapp.app.repository.ObjetRepository;

/**
 * (En tant que) détenteur d'un objet
 * (Je veux) l'ajouter au répertoire des objets recyclables
 * (Afin de) proposer au recyclage à d'autres personnes
 */
class ObjetControllerTest 
{
	private MockBean mock;
	
	@MockBean
	private ObjetRepository objetRepository;

	
	/**
	 * (Lorsque) je signale le don de l'objet A
	 * (Alors) le statut de l'objet est "disponible"
	 * (Alors) la date de signalement est apposée à l'objet
	 * (Alors) le répertoire des objets récupérable est amendé
	 * (Alors) mon porte-feuille d'objet est amendé
	 * (et) les informations fournie sont affichées
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void getObjetTest() 
	{
		when(objetRepository.findAll()).thenReturn((List<Objet>) mock);
		assertEquals(1, objetRepository.findAll()); 
	}

}
