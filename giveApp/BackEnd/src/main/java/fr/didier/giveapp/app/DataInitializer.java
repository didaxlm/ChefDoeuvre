package fr.didier.giveapp.app;

import fr.didier.giveapp.app.model.*;
import fr.didier.giveapp.app.repository.*;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
@AllArgsConstructor
@Component
public class DataInitializer implements CommandLineRunner
{
    private final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    private ArticleRepository articleDepot;
    private CategorieRepository categorieDepot;
    private FaqRepository faqDepot;
    private PhotoRepository photoDepot;
    private UserRepository userDepot;
    private VilleRepository villeDepot;
    private HistoriqueRepository historiqueDepot;

    /*
     * Formate la date
     */
    public static LocalDate parseDate(String date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }

    //Création de la BDD
    public void initData()
    {
        try
        {
            Faq regle = new Faq("Comment ça marche ? ", "Comme ça ...");
            Faq poster = new Faq("Comment je poste un objet ? ", "Tu fais ça ...");
            Faq supprimer = new Faq("Comment je supprime mon compte ? ", "Tu lèves le doigt ...");

            Categorie accessoire = new Categorie("Accessoire");
            Categorie ameublement = new Categorie("Ameublement");
            Categorie bricolage = new Categorie("Bricolage");
            Categorie electromenager = new Categorie("Electromenager");
            Categorie habillement = new Categorie("Habillement");
            Categorie loisir = new Categorie("Loisir");
            Categorie bureau = new Categorie("Matériel de bureau");
            Categorie vehicule = new Categorie("Véhicule");

            User jean = new User("Dupont", "Jean", "utilisateur", "jeanot123", "janot", "2 rue de Paris", "jean.dupont@yahoo.fr", "93100", parseDate("20/04/2019"));
            User stephanie = new User("Raleuse", "Stephanie", "utilisateur", "stephie1975", "stephie", "33 rue Raleuse", "stephie.co@yahoo.fr", "75020", parseDate("12/09/2019"));
            User jerry = new User("Chaton", "Jerry", "administrateur", "jerry1980", "jerry75", "10 rue de Beaune", "jerry.chat@yahoo.fr", "75019", parseDate("03/04/2020"));

            Ville paris = new Ville("Paris");
            Ville nantes = new Ville("Nantes");
            Ville bordeaux = new Ville("Bordeaux");

            Article table = new Article(parseDate("01/04/2020"), "Table", "Neuf", 1, ameublement, jean, paris);
            Article raquette = new Article(parseDate("02/04/2020"), "Raquette", "Bon état", 2, loisir, stephanie, nantes);
            Article marteau = new Article(parseDate("03/04/2020"), "Marteau", "Etat moyen", 2, accessoire, jerry, bordeaux);
            Article clou = new Article(parseDate("04/04/2020"), "Clou", "Neuf", 10, accessoire, jerry, nantes);

            Photo photo1 = new Photo("https://zupimages.net/up/20/16/1fbq.jpg", table);
            Photo photo2 = new Photo("https://zupimages.net/up/20/16/xwg4.jpg", raquette);
            Photo photo3 = new Photo("https://zupimages.net/up/20/16/ruir.jpg", marteau);
            Photo photo4 = new Photo("https://zupimages.net/up/20/16/vwum.jpg", clou);

            Historique histo1 = new Historique(parseDate("05/04/2020"));
            Historique histo2 = new Historique(parseDate("06/04/2020"));
            Historique histo3 = new Historique(parseDate("07/04/2020"));

            if (!faqDepot.findAll().iterator().hasNext()){
                faqDepot.saveAll(Arrays.asList(regle, poster, supprimer));
            }
            if (!categorieDepot.findAll().iterator().hasNext()){
                categorieDepot.saveAll(Arrays.asList(accessoire, ameublement, bricolage, electromenager, habillement, loisir, bureau, vehicule));
            }
            if (!userDepot.findAll().iterator().hasNext()){
                userDepot.saveAll(Arrays.asList(jean, stephanie, jerry));
            }
            if (!villeDepot.findAll().iterator().hasNext()){
                villeDepot.saveAll(Arrays.asList(paris, nantes, bordeaux));
            }
            if (!articleDepot.findAll().iterator().hasNext()){
                articleDepot.saveAll(Arrays.asList(table, raquette, marteau, clou));
            }
            if (!photoDepot.findAll().iterator().hasNext()){
                photoDepot.saveAll(Arrays.asList(photo1, photo2, photo3, photo4));
            }
            if (!historiqueDepot.findAll().iterator().hasNext()){
                historiqueDepot.saveAll(Arrays.asList(histo1, histo2, histo3));
            }

        } catch (final Exception ex) {
            logger.error("Exception lors de l'insertion de données fictives {}", ex);
        }
    }
    public void run(String... args) throws Exception
    {
        logger.info(
                "\n ******** Initializing Data ********");
        initData();

        logger.info(
                "\n ******** Data initialized ********");
    }
}
