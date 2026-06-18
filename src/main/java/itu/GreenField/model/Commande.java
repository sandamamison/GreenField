package itu.GreenField.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "commandes")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;

    @Column(name = "datecommande")
    private LocalDateTime dateCommande = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "mode_reception", nullable = false)
    private ModeReception modeReception;

    // Utilisé si Retrait_Boutique
    @ManyToOne
    @JoinColumn(name = "idptdevente_retrait")
    private PointDeVente pointDeVenteRetrait;

    // Utilisé si Livraison_Domicile
    @Column(name = "adresse_livraison", length = 255)
    private String adresseLivraison;

    @Column(name = "plage_horaire_souhaitee", length = 100)
    private String plageHoraireSouhaitee;

    @Enumerated(EnumType.STRING)
    @Column(name = "typepayement", nullable = false)
    private TypePaiement typePaiement;

    // 0 si total_produits >= 200 000 Ar
    @Column(name = "frais_livraison", nullable = false)
    private BigDecimal fraisLivraison = BigDecimal.ZERO;

    @Column(name = "total_produits", nullable = false)
    private BigDecimal totalProduits;

    @Column(name = "total_general", nullable = false)
    private BigDecimal totalGeneral;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetailsCommande> details;

    // ---- Getters & Setters ----

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public LocalDateTime getDateCommande() { return dateCommande; }
    public void setDateCommande(LocalDateTime dateCommande) { this.dateCommande = dateCommande; }

    public ModeReception getModeReception() { return modeReception; }
    public void setModeReception(ModeReception modeReception) { this.modeReception = modeReception; }

    public PointDeVente getPointDeVenteRetrait() { return pointDeVenteRetrait; }
    public void setPointDeVenteRetrait(PointDeVente pointDeVenteRetrait) { this.pointDeVenteRetrait = pointDeVenteRetrait; }

    public String getAdresseLivraison() { return adresseLivraison; }
    public void setAdresseLivraison(String adresseLivraison) { this.adresseLivraison = adresseLivraison; }

    public String getPlageHoraireSouhaitee() { return plageHoraireSouhaitee; }
    public void setPlageHoraireSouhaitee(String plageHoraireSouhaitee) { this.plageHoraireSouhaitee = plageHoraireSouhaitee; }

    public TypePaiement getTypePaiement() { return typePaiement; }
    public void setTypePaiement(TypePaiement typePaiement) { this.typePaiement = typePaiement; }

    public BigDecimal getFraisLivraison() { return fraisLivraison; }
    public void setFraisLivraison(BigDecimal fraisLivraison) { this.fraisLivraison = fraisLivraison; }

    public BigDecimal getTotalProduits() { return totalProduits; }
    public void setTotalProduits(BigDecimal totalProduits) { this.totalProduits = totalProduits; }

    public BigDecimal getTotalGeneral() { return totalGeneral; }
    public void setTotalGeneral(BigDecimal totalGeneral) { this.totalGeneral = totalGeneral; }

    public List<DetailsCommande> getDetails() { return details; }
    public void setDetails(List<DetailsCommande> details) { this.details = details; }
}
