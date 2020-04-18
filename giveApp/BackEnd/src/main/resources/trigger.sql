DROP TRIGGER IF EXISTS histo^;
CREATE TRIGGER histo BEFORE DELETE ON article
FOR EACH ROW BEGIN
    INSERT INTO monshema.historique VALUES OLD.monarticlesupprime;
END^;
