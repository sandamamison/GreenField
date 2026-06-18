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
('Persil', 'PLTP-005', 2950.00, 'Plante potagere'),
('Rose', 'PLTF-001', 15000.00, 'Plante fleurie'),
('Tulipe', 'PLTF-002', 35000.00, 'Plante fleurie'),
('Lys', 'PLTF-003', 25000.00, 'Plante fleurie'),
('Orchidée', 'PLTF-004', 12000.00, 'Plante fleurie'),
('Géranium', 'PLTF-005', 18000.00, 'Plante fleurie');


INSERT INTO pointdevente (nom, reference, adresse, contact) VALUES
('Centrale', 'CTR-001', 'IAH 23I Vontovorona', '034 12 345 67'),
('Kiosque Nord', 'BTQ-001', 'Avenue du Nord, Antananarivo', '034 12 345 68'),
('Kiosque Sud', 'BTQ-002', 'Avenue du Sud, Antananarivo', '034 12 345 69'),
('Kiosque Est', 'BTQ-003', 'Avenue Est, Antananarivo', '034 12 345 70'),
('Kiosque Ouest', 'BTQ-004', 'Avenue Ouest, Antananarivo', '034 12 345 71');

/* Données de production du central */
INSERT INTO MvtStock (type_mouvement, idproduit, refptdevente, quantite) VALUES
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'CMP-001'), 'CTR-001', 1000), -- Compost (1kg) à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'CMP-002'), 'CTR-001', 1000),  -- Compost (5kg) à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'CMP-003'), 'CTR-001', 1000),  -- Compost (10kg) à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'CMP-004'), 'CTR-001', 1000),  -- Compost (50kg) à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'ENG-001'), 'CTR-001', 1000), -- Terre melangée à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTR-001'), 'CTR-001', 1500), -- Pin à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTR-002'), 'CTR-001', 1500), -- Ficus à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTR-003'), 'CTR-001', 1500), -- Monstera à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTR-004'), 'CTR-001', 1500), -- Succulente à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTR-005'), 'CTR-001', 1500), -- Bambou à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTP-001'), 'CTR-001', 1000), -- Orangier à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTP-002'), 'CTR-001', 1000), -- Tomate à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTP-003'), 'CTR-001', 1000), -- Basilic à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTP-004'), 'CTR-001', 1000), -- Menthe à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTP-005'), 'CTR-001', 1000), -- Persil à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTF-001'), 'CTR-001', 500),   -- Rose à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTF-002'), 'CTR-001', 500),   -- Tulipe à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTF-003'), 'CTR-001', 500),   -- Lys à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTF-004'), 'CTR-001', 500),   -- Orchidée à l'unité centrale
('Entree_Production', (SELECT id FROM Produit WHERE matricule = 'PLTF-005'), 'CTR-001', 500);   -- Géranium

/* Données de mouvement de stock pour les kiosques pour BTQ-001 */
INSERT INTO MvtStock (type_mouvement, idproduit, refptdevente, quantite) VALUES
('Sortie_Transfert', (SELECT id FROM Produit WHERE matricule = 'CMP-001'), 'CTR-001', 200), -- Transfert de Compost (1kg) vers Boutique Centrale
('Sortie_Transfert', (SELECT id FROM Produit WHERE matricule = 'CMP-002'), 'CTR-001', 20),  -- Transfert de Compost (5kg) vers Boutique Centrale
('Sortie_Transfert', (SELECT id FROM Produit WHERE matricule = 'CMP-003'), 'CTR-001', 60),  -- Transfert de Compost (10kg) vers Boutique Centrale
('Sortie_Transfert', (SELECT id FROM Produit WHERE matricule = 'CMP-004'), 'CTR-001', 40),  -- Transfert de Compost (50kg) vers Boutique Centrale
('Sortie_Transfert', (SELECT id FROM Produit WHERE matricule = 'CMP-005'), 'CTR-001', 40), -- Transfert de Terre melangée vers Boutique Centrale
('Sortie_Transfert', (SELECT id FROM Produit WHERE matricule = 'CMP-006'), 'CTR-001', 30), -- Transfert de Pin vers Boutique
('Entree_Boutique', (SELECT id FROM Produit WHERE matricule = 'PLTR-001'), 'BTQ-001', 200), -- Réception de Pin à la Boutique
('Entree_Boutique', (SELECT id FROM Produit WHERE matricule = 'PLTR-002'), 'BTQ-001', 20), -- Réception de Ficus à la Boutique
('Entree_Boutique', (SELECT id FROM Produit WHERE matricule = 'PLTR-003'), 'BTQ-001', 60), -- Réception de Monstera à la Boutique
('Entree_Boutique', (SELECT id FROM Produit WHERE matricule = 'PLTR-004'), 'BTQ-001', 40), -- Réception de Succulente à la Boutique
('Entree_Boutique', (SELECT id FROM Produit WHERE matricule = 'PLTR-005'), 'BTQ-001', 40), -- Réception de Bambou à la Boutique
('Entree_Boutique', (SELECT id FROM Produit WHERE matricule = 'PLTP-004'), 'BTQ-001', 30); -- Réception de Orangier à la Boutique

/* Données de mouvement de stock pour les kiosques pour BTQ-002 */
INSERT INTO MvtStock (type_mouvement, idproduit, refptdevente, quantite) VALUES
('Sortie_Transfert', (SELECT id FROM Produit WHERE matricule = 'CMP-001'), 'CTR-001', 150), -- Transfert de Compost (1kg) vers Boutique Centrale
('Sortie_Transfert', (SELECT id FROM Produit WHERE matricule = 'CMP-002'), 'CTR-001', 15),  -- Transfert de Compost (5kg) vers Boutique Centrale
('Sortie_Transfert', (SELECT id FROM Produit WHERE matricule = 'CMP-003'), 'CTR-001', 45),  -- Transfert de Compost (10kg) vers Boutique Centrale
('Sortie_Transfert', (SELECT id FROM Produit WHERE matricule = 'CMP-004'), 'CTR-001', 30),  -- Transfert de Compost (50kg) vers Boutique Centrale
('Sortie_Transfert', (SELECT id FROM Produit WHERE matricule = 'CMP-005'), 'CTR-001', 30), -- Transfert de Terre melangée vers Boutique Centrale
('Sortie_Transfert', (SELECT id FROM Produit WHERE matricule = 'CMP-006'), 'CTR-001', 20), -- Transfert de Pin vers Boutique
('Entree_Boutique', (SELECT id FROM Produit WHERE matricule = 'PLTR-001'), 'BTQ-002', 150), -- Réception de Pin à la Boutique
('Entree_Boutique', (SELECT id FROM Produit WHERE matricule = 'PLTR-002'), 'BTQ-002', 15), -- Réception de Ficus à la Boutique
('Entree_Boutique', (SELECT id FROM Produit WHERE matricule = 'PLTR-003'), 'BTQ-002', 45), -- Réception de Monstera à la Boutique
('Entree_Boutique', (SELECT id FROM Produit WHERE matricule = 'PLTR-004'), 'BTQ-002', 30), -- Réception de Succulente à la Boutique
('Entree_Boutique', (SELECT id FROM Produit WHERE matricule = 'PLTR-005'), 'BTQ-002', 30), -- Réception de Bambou à la Boutique
('Entree_Boutique', (SELECT id FROM Produit WHERE matricule = 'PLTP-004'), 'BTQ-002', 150); -- Réception de Orangier à la Boutique