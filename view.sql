--view premettre de calcul les stocks en temp reel 
CREATE OR REPLACE VIEW ViewEtatStockGlobalActuel AS
SELECT p.id AS id, p.nom, p.matricule, p.pu, p.categorie, COALESCE(
        (
            SELECT SUM(
                    CASE
                        WHEN m.type_mouvement IN (
                            'Entree_Production', 'Entree_Boutique'
                        ) THEN m.quantite
                        WHEN m.type_mouvement IN (
                            'Sortie_Transfert', 'Vente_Client', 'Perte'
                        ) THEN - m.quantite
                        ELSE 0
                    END
                )
            FROM MvtStock m
            WHERE
                m.idproduit = p.id
        ), 0
    ) AS quantite
FROM Produit p;