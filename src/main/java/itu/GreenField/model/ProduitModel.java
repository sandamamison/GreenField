package itu.GreenField.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nom;

    @Column(nullable = false, unique = true, length = 50)
    private String matricule;

    @Column(nullable = false)
    private BigDecimal pu;

    @Column(length = 50)
    private String categorie;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public BigDecimal getPu() { return pu; }
    public void setPu(BigDecimal pu) { this.pu = pu; }

    public String getCategorie() { return categorie; }
    public void setCategorie(String categorie) { this.categorie = categorie; }
}
