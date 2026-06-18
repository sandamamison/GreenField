package itu.GreenField.service;

import itu.GreenField.dto.CommandeRequest;
import itu.GreenField.model.*;
import itu.GreenField.repository.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    // Seuil au-delà duquel la livraison est offerte (règle métier MVP)
    private static final BigDecimal SEUIL_LIVRAISON_GRATUITE = new BigDecimal("200000");
    private static final BigDecimal FRAIS_LIVRAISON_STANDARD = new BigDecimal("5000");

    private final CommandeRepository commandeRepository;
    private final ClientRepository clientRepository;
    private final ProduitRepository produitRepository;
    private final PointDeVenteRepository pointDeVenteRepository;

    public CommandeService(CommandeRepository commandeRepository,
                           ClientRepository clientRepository,
                           ProduitRepository produitRepository,
                           PointDeVenteRepository pointDeVenteRepository) {
        this.commandeRepository = commandeRepository;
        this.clientRepository = clientRepository;
        this.produitRepository = produitRepository;
        this.pointDeVenteRepository = pointDeVenteRepository;
    }

    // =========================================================
    // CRÉER UNE COMMANDE
    // =========================================================
    @Transactional
    public Commande creerCommande(CommandeRequest req) {

        // 1. Vérifier le client
        Client client = clientRepository.findById(req.getClientId())
                .orElseThrow(() -> new IllegalArgumentException("Client introuvable : id=" + req.getClientId()));

        // 2. Valider les champs selon le mode de réception
        if (req.getModeReception() == null) {
            throw new IllegalArgumentException("Le mode de réception est obligatoire.");
        }
        if (req.getModeReception() == ModeReception.Retrait_Boutique && req.getPointDeVenteRetraitId() == null) {
            throw new IllegalArgumentException("Un point de vente est requis pour un retrait en boutique.");
        }
        if (req.getModeReception() == ModeReception.Livraison_Domicile
                && (req.getAdresseLivraison() == null || req.getAdresseLivraison().isBlank())) {
            throw new IllegalArgumentException("Une adresse de livraison est requise pour une livraison à domicile.");
        }

        // 3. Valider les lignes de commande
        if (req.getLignes() == null || req.getLignes().isEmpty()) {
            throw new IllegalArgumentException("La commande doit contenir au moins un produit.");
        }

        // 4. Construire les lignes & calculer le total produits
        List<DetailsCommande> details = new ArrayList<>();
        BigDecimal totalProduits = BigDecimal.ZERO;

        for (CommandeRequest.LigneCommande ligne : req.getLignes()) {
            if (ligne.getQuantite() == null || ligne.getQuantite() <= 0) {
                throw new IllegalArgumentException("La quantité doit être supérieure à 0.");
            }

            Produit produit = produitRepository.findById(ligne.getProduitId())
                    .orElseThrow(() -> new IllegalArgumentException("Produit introuvable : id=" + ligne.getProduitId()));

            DetailsCommande detail = new DetailsCommande();
            detail.setProduit(produit);
            detail.setQuantite(ligne.getQuantite());
            // On fige le prix au moment de l'achat (règle d'historisation)
            detail.setPuAuMomentAchat(produit.getPu());

            BigDecimal sousTotal = produit.getPu().multiply(BigDecimal.valueOf(ligne.getQuantite()));
            totalProduits = totalProduits.add(sousTotal);

            details.add(detail);
        }

        // 5. Calculer les frais de livraison
        BigDecimal fraisLivraison = BigDecimal.ZERO;
        if (req.getModeReception() == ModeReception.Livraison_Domicile) {
            // Livraison offerte si total >= 200 000 Ar
            fraisLivraison = totalProduits.compareTo(SEUIL_LIVRAISON_GRATUITE) >= 0
                    ? BigDecimal.ZERO
                    : FRAIS_LIVRAISON_STANDARD;
        }

        BigDecimal totalGeneral = totalProduits.add(fraisLivraison);

        // 6. Construire la commande
        Commande commande = new Commande();
        commande.setClient(client);
        commande.setModeReception(req.getModeReception());
        commande.setTypePaiement(req.getTypePaiement());
        commande.setFraisLivraison(fraisLivraison);
        commande.setTotalProduits(totalProduits);
        commande.setTotalGeneral(totalGeneral);

        if (req.getModeReception() == ModeReception.Retrait_Boutique) {
            PointDeVente pdv = pointDeVenteRepository.findById(req.getPointDeVenteRetraitId())
                    .orElseThrow(() -> new IllegalArgumentException("Point de vente introuvable."));
            commande.setPointDeVenteRetrait(pdv);
        } else {
            commande.setAdresseLivraison(req.getAdresseLivraison());
            commande.setPlageHoraireSouhaitee(req.getPlageHoraireSouhaitee());
        }

        // 7. Lier les détails à la commande (relation bidirectionnelle)
        for (DetailsCommande detail : details) {
            detail.setCommande(commande);
        }
        commande.setDetails(details);

        return commandeRepository.save(commande);
    }

    // =========================================================
    // LIRE
    // =========================================================

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Optional<Commande> getCommandeById(Integer id) {
        return commandeRepository.findById(id);
    }

    public List<Commande> getCommandesByClient(Integer clientId) {
        if (!clientRepository.existsById(clientId)) {
            throw new IllegalArgumentException("Client introuvable : id=" + clientId);
        }
        return commandeRepository.findByClientId(clientId);
    }

    // =========================================================
    // ANNULER (soft : non implémenté ici car pas de statut commande en MVP)
    // Pour l'instant on supprime physiquement si nécessaire
    // =========================================================

    @Transactional
    public boolean annulerCommande(Integer id) {
        if (!commandeRepository.existsById(id)) {
            return false;
        }
        commandeRepository.deleteById(id);
        return true;
    }
}
