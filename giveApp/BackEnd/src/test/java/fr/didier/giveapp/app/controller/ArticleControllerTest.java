package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.model.Article;
import fr.didier.giveapp.app.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * (En tant que) détenteur d'un objet
 * (Je veux) l'ajouter au répertoire des objets recyclables
 * (Afin de) proposer au recyclage à d'autres personnes
 */
@SpringBootTest
@AutoConfigureMockMvc
class ArticleControllerTest
{
	private MockBean mockBean;
	
	@MockBean
	private ArticleRepository articleRepository;

	@Test
	public void getObjetTest() 
	{
		when(articleRepository.findAll()).thenReturn((List<Article>) mockBean);
		assertEquals(1, articleRepository.findAll()); 
	}

	/**
	 * (Lorsque) je signale le don de l'objet A
	 * (Alors) le statut de l'objet est "disponible"
	 * (Alors) la date de signalement est apposée à l'objet
	 * (Alors) le répertoire des objets récupérable est amendé
	 * (Alors) mon porte-feuille d'objet est amendé
	 * (et) les informations fournie sont affichées
	 */
}
