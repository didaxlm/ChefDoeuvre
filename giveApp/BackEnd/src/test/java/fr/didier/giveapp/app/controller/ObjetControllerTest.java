package fr.didier.giveapp.app.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.repository.ArticleRepository;

/**
 * (En tant que) d�tenteur d'un objet
 * (Je veux) l'ajouter au r�pertoire des objets recyclables
 * (Afin de) proposer au recyclage � d'autres personnes
 */
class ObjetControllerTest 
{
	private MockBean mock;
	
	@MockBean
	private ArticleRepository articleRepository;

	
	/**
	 * (Lorsque) je signale le don de l'objet A
	 * (Alors) le statut de l'objet est "disponible"
	 * (Alors) la date de signalement est appos�e � l'objet
	 * (Alors) le r�pertoire des objets r�cup�rable est amend�
	 * (Alors) mon porte-feuille d'objet est amend�
	 * (et) les informations fournie sont affich�es
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void getObjetTest() 
	{
		when(articleRepository.findAll()).thenReturn((List<Article>) mock);
		assertEquals(1, articleRepository.findAll()); 
	}

}
