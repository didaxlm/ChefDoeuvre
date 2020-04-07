package fr.didier.giveapp.app;

import fr.didier.giveapp.app.model.*;
import fr.didier.giveapp.app.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component
public class DataInitializer
{
    private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    private ArticleRepository articleDepot;
    private CategorieRepository categorieDepot;
    private FaqRepository faqDepot;
    private PhotoRepository photoDepot;
    private UserRepository userDepot;
    private VilleRepository villeDepot;
    private HistoriqueRepository historiqueDepot;

    public static LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    public DataInitializer(final ArticleRepository articleDepot, final CategorieRepository categorieDepot, final FaqRepository faqDepot, final PhotoRepository photoDepot, final UserRepository userDepot, final VilleRepository villeDepot, final HistoriqueRepository historiqueDepot)
    {
        this.articleDepot = articleDepot;
        this.categorieDepot = categorieDepot;
        this.faqDepot = faqDepot;
        this.photoDepot = photoDepot;
        this.userDepot = userDepot;
        this.villeDepot = villeDepot;
        this.historiqueDepot = historiqueDepot;
    }

    //Création de la BDD
    public void initData()
    {
        try
        {
            Faq regle = new Faq("Comment ça marche ? ", "Comme ça ...");
            Faq poster = new Faq("Comment je poste un objet ? ", "Tu fais ça ...");
            Faq supprimer = new Faq("Comment je supprime mon compte ? ", "Tu lèves le doigt ...");

            Categorie ameublement = new Categorie("Ameublement");
            Categorie loisir = new Categorie("Loisir");
            Categorie outillage = new Categorie("Outillage");

            User jean = new User("Dupont", "Jean", 1, "jeanot123", "janot", "2 rue de Paris", "jean.dupont@yahoo.fr", "93100", parseDate("20/04/2019"));
            User stephanie = new User("Raleuse", "Stephanie", 1, "stephie1975", "stephie", "33 rue Raleuse", "stephie.co@yahoo.fr", "75020", parseDate("12/09/2019"));
            User jerry = new User("Chaton", "Jerry", 0, "jerry1980", "jerry75", "10 rue de Beaune", "jerry.chat@yahoo.fr", "75019", parseDate("03/04/2020"));

            Ville paris = new Ville("Paris");
            Ville nantes = new Ville("Nantes");
            Ville bordeaux = new Ville("Bordeaux");

            Article table = new Article(parseDate("01/04/2020"), "Table", "Neuf", 1);
            ameublement.addCategorie(table);
            jean.addUser(table);
            paris.addVille(table);
            Article raquette = new Article(parseDate("02/04/2020"), "Raquette", "Bon état", 2);
            loisir.addCategorie(raquette);
            stephanie.addUser(raquette);
            nantes.addVille(raquette);
            Article marteau = new Article(parseDate("03/04/2020"), "Marteau", "Etat moyen", 2);
            outillage.addCategorie(marteau);
            jerry.addUser(marteau);
            bordeaux.addVille(marteau);

            Photo photo1 = new Photo("https://www.dropbox.com/s/z7en8i65a156d2l/table.jpg?dl=0");
            table.addArticle(photo1);
            Photo photo2 = new Photo("https://www.dropbox.com/s/2z0vy2xdhw8g7gb/raquette.jpg?dl=0");
            raquette.addArticle(photo2);
            Photo photo3 = new Photo("https://www.dropbox.com/s/4qs94brm9vmxg9r/marteau.jpg?dl=0");
            marteau.addArticle(photo3);

            Historique histo1 = new Historique(parseDate("05/04/2020"));
            Historique histo2 = new Historique(parseDate("06/04/2020"));
            Historique histo3 = new Historique(parseDate("07/04/2020"));

            if (!faqDepot.findAll().iterator().hasNext()){
                faqDepot.saveAll(Arrays.asList(regle, poster, supprimer));
            }
            if (!categorieDepot.findAll().iterator().hasNext()){
                categorieDepot.saveAll(Arrays.asList(ameublement, loisir, outillage));
            }
            if (!userDepot.findAll().iterator().hasNext()){
                userDepot.saveAll(Arrays.asList(jean, stephanie, jerry));
            }
            if (!villeDepot.findAll().iterator().hasNext()){
                villeDepot.saveAll(Arrays.asList(paris, nantes, bordeaux));
            }
            if (!articleDepot.findAll().iterator().hasNext()){
                articleDepot.saveAll(Arrays.asList(table, raquette, marteau));
            }
            if (!photoDepot.findAll().iterator().hasNext()){
                photoDepot.saveAll(Arrays.asList(photo1, photo2, photo3));
            }
            if (!historiqueDepot.findAll().iterator().hasNext()){
                historiqueDepot.saveAll(Arrays.asList(histo1, histo2, histo3));
            }

        } catch (final Exception ex) {
            logger.error("Exception lors de l'insertion de données fictives {}", ex);
        }
    }
}
