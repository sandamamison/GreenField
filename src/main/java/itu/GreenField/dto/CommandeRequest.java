package itu.GreenField.dto;

import itu.GreenField.model.ModeReception;
import itu.GreenField.model.TypePaiement;

import java.util.List;

/**
 * Corps de la requête POST /api/commandes
 * Le client et les produits sont en dur (identifiés par ID).
 */
public class CommandeRequest {

    private Integer clientId;

    private ModeReception modeReception;

    // Requis si modeReception == Retrait_Boutique
    private Integer pointDeVenteRetraitId;

    // Requis si modeReception == Livraison_Domicile
    private String adresseLivraison;
    private String plageHoraireSouhaitee;

    private TypePaiement typePaiement;

    private List<LigneCommande> lignes;

    // ---- Inner DTO ----

    public static class LigneCommande {
        private Integer produitId;
        private Integer quantite;

        public Integer getProduitId() { return produitId; }
        public void setProduitId(Integer produitId) { this.produitId = produitId; }

        public Integer getQuantite() { return quantite; }
        public void setQuantite(Integer quantite) { this.quantite = quantite; }
    }

    // ---- Getters & Setters ----

    public Integer getClientId() { return clientId; }
    public void setClientId(Integer clientId) { this.clientId = clientId; }

    public ModeReception getModeReception() { return modeReception; }
    public void setModeReception(ModeReception modeReception) { this.modeReception = modeReception; }

    public Integer getPointDeVenteRetraitId() { return pointDeVenteRetraitId; }
    public void setPointDeVenteRetraitId(Integer pointDeVenteRetraitId) { this.pointDeVenteRetraitId = pointDeVenteRetraitId; }

    public String getAdresseLivraison() { return adresseLivraison; }
    public void setAdresseLivraison(String adresseLivraison) { this.adresseLivraison = adresseLivraison; }

    public String getPlageHoraireSouhaitee() { return plageHoraireSouhaitee; }
    public void setPlageHoraireSouhaitee(String plageHoraireSouhaitee) { this.plageHoraireSouhaitee = plageHoraireSouhaitee; }

    public TypePaiement getTypePaiement() { return typePaiement; }
    public void setTypePaiement(TypePaiement typePaiement) { this.typePaiement = typePaiement; }

    public List<LigneCommande> getLignes() { return lignes; }
    public void setLignes(List<LigneCommande> lignes) { this.lignes = lignes; }
}
