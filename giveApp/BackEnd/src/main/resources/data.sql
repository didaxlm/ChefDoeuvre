DROP TRIGGER IF EXISTS histo^;
CREATE TRIGGER histo BEFORE DELETE ON article
FOR EACH ROW BEGIN
    INSERT INTO giveappbdd.historique VALUES (OLD.id, OLD.date_depot, NOW(), OLD.etat_article, OLD.lieu_article, OLD.nom_article, OLD.quantite_article);
END^;
