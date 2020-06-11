package fr.didier.giveapp.app.controller;

import fr.didier.giveapp.app.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * (En tant que) détenteur d'un article
 * (Je veux) intérroger ma base de donnée
 * (Afin de) de traiter les articles
 */
@SpringBootTest
@AutoConfigureMockMvc
class ArticleControllerTest
{
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ArticleRepository articleDepot;

	/**
	 * (Lorsque) j'appelle mon dépot des articles
	 * (Alors) je reçois une réponse du serveur
	 * (Et) le status est "ok"
	 * @throws Exception
	 */
	@Test
	void afficherArticle() throws Exception
	{
		when(articleDepot.findAll()).thenReturn(null);

		ResultActions validResponse = this.mockMvc.perform(get("/articles/"));
		validResponse.andExpect(status().isOk());

		ResultActions invalidResponse = this.mockMvc.perform(get("/fake"));
		invalidResponse.andExpect(status().isForbidden());
	}

	@Test
	void testAfficherArticle() {
	}

	@Test
	void afficherArticlesByLieu() {
	}

	@Test
	void afficherArticlesByCategorie() {
	}

	@Test
	void afficherArticlesByUser() {
	}

	@Test
	void ajouterArticle() {
	}

	@Test
	void supprimerArticle() {
	}

}
