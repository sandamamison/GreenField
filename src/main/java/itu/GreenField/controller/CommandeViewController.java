package itu.GreenField.controller;

import itu.GreenField.model.Produit;
import itu.GreenField.repository.ProduitRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CommandeViewController {

    private final ProduitRepository produitRepository;

    // Lire le port depuis application.properties (défaut : 8090)
    @Value("${server.port:8090}")
    private String serverPort;

    public CommandeViewController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    /**
     * GET /commandes/new
     * Affiche le formulaire de test pour créer une commande.
     */
    @GetMapping("/commandes/new")
    public String formulaireCommande(Model model) {
        List<Produit> produits = produitRepository.findAll();
        model.addAttribute("produits", produits);
        model.addAttribute("apiBase", "http://localhost:" + serverPort);
        return "commande-form";
    }
}
