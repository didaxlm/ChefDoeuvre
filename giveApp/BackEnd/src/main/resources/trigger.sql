DROP TRIGGER IF EXISTS histo^;
CREATE TRIGGER histo BEFORE DELETE ON article
FOR EACH ROW BEGIN
    INSERT INTO giveappbdd.historique VALUES OLD.id.date_depot etc ...;
END^;
