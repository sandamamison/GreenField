package itu.GreenField.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employes")
public class EmployeeModel {

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "idptdevente", foreignKey = @ForeignKey(name = "fk_employe_pointdevente"))
    private PointDeVente pointDeVente;

    @Column(name = "est_actif")
    private Boolean estActif = true;

    // Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public PointDeVente getPointDeVente() {
        return pointDeVente;
    }

    public void setPointDeVente(PointDeVente pointDeVente) {
        this.pointDeVente = pointDeVente;
    }

    public Boolean getEstActif() {
        return estActif;
    }

    public void setEstActif(Boolean estActif) {
        this.estActif = estActif;
    }
}