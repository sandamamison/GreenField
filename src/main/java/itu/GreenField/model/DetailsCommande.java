package itu.GreenField.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;

@Entity
@Table(name = "detailscommande")
public class DetailsCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idcommande", nullable = false)
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "idproduit", nullable = false)
    private Produit produit;

    @Column(nullable = false)
    private Integer quantite;

    // Prix figé au moment de la commande (règle métier : immuable)
    @Column(name = "pu_au_moment_achat", nullable = false)
    private BigDecimal puAuMomentAchat;

    // ---- Getters & Setters ----

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Commande getCommande() { return commande; }
    public void setCommande(Commande commande) { this.commande = commande; }

    public Produit getProduit() { return produit; }
    public void setProduit(Produit produit) { this.produit = produit; }

    public Integer getQuantite() { return quantite; }
    public void setQuantite(Integer quantite) { this.quantite = quantite; }

    public BigDecimal getPuAuMomentAchat() { return puAuMomentAchat; }
    public void setPuAuMomentAchat(BigDecimal puAuMomentAchat) { this.puAuMomentAchat = puAuMomentAchat; }
}
