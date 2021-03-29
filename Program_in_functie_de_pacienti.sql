DROP VIEW IF EXISTS Orar_programari;

CREATE VIEW Orar_Programari AS 
SELECT CONCAT(P.nume, ' ', P.prenume) AS 'Pacient', ora_inceperii, ora_finalizarii, 
CONCAT(U.nume, ' ', U.prenume) AS 'medic'
FROM programari Pr, medic M, pacienti P, utilizatori U
WHERE id_medic = medicul AND Pr.id_pacient = P.id_pacient 
AND Id_ca_utilizator = id_utilizator;

DROP VIEW IF EXISTS Program_Angajat;

CREATE VIEW Program_Angajat AS 
SELECT datapr AS 'Data', CONCAT(Pr.ora_incepere, ' - ', Pr.ora_plecare) AS 'Program',
U.denumire AS 'Unitate medicala', U.adresa, utilizatori.nume, id_angajat
FROM programangajati Pr, angajat A, unitati_medicale U, utilizatori
WHERE id_unitate_medicala = unitate  
AND id_angajat = Pr.id_ca_angajat AND id_angajat = utilizatori.id_ca_angajat;

