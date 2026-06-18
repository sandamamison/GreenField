-- update table PointDeVente to add a new column "reference" to differentiate between central store and kiosks

ALTER DATABASE greenfield SET timezone TO 'Indian/Antananarivo';

ALTER TABLE PointDeVente
ADD COLUMN reference VARCHAR(50) NOT NULL UNIQUE;

ALTER TABLE MvtStock 
DROP COLUMN idptdevente;

ALTER TABLE MvtStock 
ADD COLUMN refptdevente VARCHAR(50) REFERENCES PointDeVente(reference);