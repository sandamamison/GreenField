/* data for table Produit */

INSERT INTO Produit (nom, matricule, pu, categorie) VALUES
('Compost (1kg)', 'CMP-001', 3000.00, 'Compost'),
('Compost (5kg)', 'CMP-002', 13500.00, 'Compost'),
('Compost (10kg)', 'CMP-003', 27000.00, 'Compost'),
('Compost (50kg)', 'CMP-004', 121500.00, 'Compost'),
('Terre melangée', 'ENG-001', 8000.00, 'Terre'),
('Pin', 'PLTR-001', 1700.00, 'Plante pour reboisement'),
('Ficus', 'PLTR-002', 1700.00, 'Plante pour reboisement'),
('Monstera', 'PLTR-003', 1700.00, 'Plante pour reboisement'),
('Succulente', 'PLTR-004', 1700.00, 'Plante pour reboisement'),
('Bambou', 'PLTR-005', 1700.00, 'Plante pour reboisement'),
('Orangier', 'PLTP-001', 2950.00, 'Plante potagere'),
('Tomate', 'PLTP-002', 2950.00, 'Plante potagere'),
('Basilic', 'PLTP-003', 2950.00, 'Plante potagere'),
('Menthe', 'PLTP-004', 2950.00, 'Plante potagere'),
('Persil', 'PLTP-005', 2950.00, 'Plante potagere');
('Rose', 'PLTF-001', 15000.00, 'Plante fleurie'),
('Tulipe', 'PLTF-002', 35000.00, 'Plante fleurie'),
('Lys', 'PLTF-003', 25000.00, 'Plante fleurie'),
('Orchidée', 'PLTF-004', 12000.00, 'Plante fleurie'),
('Géranium', 'PLTF-005', 18000.00, 'Plante fleurie');


INSERT INTO PointDeVente (nom, reference, adresse) VALUES
('Boutique Centrale', 'CTR-001', '123 Rue Principale, Antananarivo'),
('Kiosque Nord', 'BTQ-001', 'Avenue du Nord, Antananarivo'),
('Kiosque Sud', 'BTQ-002', 'Avenue du Sud, Antananarivo'),
('Kiosque Est', 'BTQ-003', 'Avenue de l\'Est, Antananarivo'),
('Kiosque Ouest', 'BTQ-004', 'Avenue de l\'Ouest, Antananarivo');

/* Données de production du central */
INSERT INTO MvtStock (type_mouvement, idproduit, idptdevente, quantite) VALUES
('Entree_Production', 1, NULL, 1000), -- Compost (1kg) à l'unité centrale
('Entree_Production', 2, NULL, 1000),  -- Compost (5kg) à l'unité centrale
('Entree_Production', 3, NULL, 1000),  -- Compost (10kg) à l'unité centrale
('Entree_Production', 4, NULL, 1000),  -- Compost (50kg) à l'unité centrale
('Entree_Production', 5, NULL, 1000), -- Terre melangée à l'unité centrale
('Entree_Production', 6, NULL, 1500), -- Pin à l'unité centrale
('Entree_Production', 7, NULL, 1500), -- Ficus à l'unité centrale
('Entree_Production', 8, NULL, 1500), -- Monstera à l'unité centrale
('Entree_Production', 9, NULL, 1500), -- Succulente à l'unité centrale
('Entree_Production', 10, NULL, 1500), -- Bambou à l'unité centrale
('Entree_Production', 11, NULL, 1000), -- Orangier à l'unité centrale
('Entree_Production', 12, NULL, 1000), -- Tomate à l'unité centrale
('Entree_Production', 13, NULL, 1000), -- Basilic à l'unité centrale
('Entree_Production', 14, NULL, 1000), -- Menthe à l'unité centrale
('Entree_Production', 15, NULL, 1000), -- Persil à l'unité centrale
('Entree_Production', 16, NULL, 500),   -- Rose à l'unité centrale
('Entree_Production', 17, NULL, 500),   -- Tulipe à l'unité centrale
('Entree_Production', 18, NULL, 500),   -- Lys à l'unité centrale
('Entree_Production', 19, NULL, 500),   -- Orchidée à l'unité centrale
('Entree_Production', 20, NULL, 500);   -- Géranium

/* Données de mouvement de stock pour les kiosques pour BTQ-001 */
INSERT INTO MvtStock (type_mouvement, idproduit, idptdevente, quantite) VALUES
('Sortie_Transfert', 1, NULL, 200), -- Transfert de Compost (1kg) vers Boutique Centrale
('Sortie_Transfert', 2, NULL, 20),  -- Transfert de Compost (5kg) vers Boutique Centrale
('Sortie_Transfert', 3, NULL, 60),  -- Transfert de Compost (10kg) vers Boutique Centrale
('Sortie_Transfert', 4, NULL, 40),  -- Transfert de Compost (50kg) vers Boutique Centrale
('Sortie_Transfert', 5, NULL, 40), -- Transfert de Terre melangée vers Boutique Centrale
('Sortie_Transfert', 6, NULL, 30), -- Transfert de Pin vers Boutique
('Entree_Boutique', 1, 1, 200), -- Réception de Pin à la Boutique
('Entree_Boutique', 2, 1, 20), -- Réception de Ficus à la Boutique
('Entree_Boutique', 3, 1, 60), -- Réception de Monstera à la Boutique
('Entree_Boutique', 4, 1, 40), -- Réception de Succulente à la Boutique
('Entree_Boutique', 5, 1, 40); -- Réception de Bambou à la Boutique
('Entree_Boutique', 6, 1, 30); -- Réception de Orangier à la Boutique

/* Données de mouvement de stock pour les kiosques pour BTQ-002 */
INSERT INTO MvtStock (type_mouvement, idproduit, idptdevente, quantite) VALUES
('Sortie_Transfert', 1, NULL, 150), -- Transfert de Compost (1kg) vers Boutique Centrale
('Sortie_Transfert', 2, NULL, 15),  -- Transfert de Compost (5kg) vers Boutique Centrale
('Sortie_Transfert', 3, NULL, 45),  -- Transfert de Compost (10kg) vers Boutique Centrale
('Sortie_Transfert', 4, NULL, 30),  -- Transfert de Compost (50kg) vers Boutique Centrale
('Sortie_Transfert', 5, NULL, 30), -- Transfert de Terre melangée vers Boutique Centrale
('Sortie_Transfert', 6, NULL, 20), -- Transfert de Pin vers Boutique
('Entree_Boutique', 1, 2, 150), -- Réception de Pin à la Boutique
('Entree_Boutique', 2, 2, 15), -- Réception de Ficus à la Boutique
('Entree_Boutique', 3, 2, 45), -- Réception de Monstera à la Boutique
('Entree_Boutique', 4, 2, 30), -- Réception de Succulente à la Boutique
('Entree_Boutique', 5, 2, 30); -- Réception de Bambou à la Boutique
('Entree_Boutique', 6, 2, 20); -- Réception de Orangier à la Boutique