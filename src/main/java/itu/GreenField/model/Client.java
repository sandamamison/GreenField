package itu.GreenField.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, length = 100)
    private String prenom;

    @Column(length = 255)
    private String adresse;

    @Column(length = 50)
    private String contact;

    @Column(nullable = false, unique = true, length = 150)
    private String mail;

    @JsonIgnore
    @Column(nullable = false, length = 255)
    private String motdepasse;

    @Column(name = "soldefidelite")
    private BigDecimal soldeFidelite = BigDecimal.ZERO;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public String getMotdepasse() { return motdepasse; }
    public void setMotdepasse(String motdepasse) { this.motdepasse = motdepasse; }

    public BigDecimal getSoldeFidelite() { return soldeFidelite; }
    public void setSoldeFidelite(BigDecimal soldeFidelite) { this.soldeFidelite = soldeFidelite; }
}
