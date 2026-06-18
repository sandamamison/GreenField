package itu.GreenField.controller;

import itu.GreenField.dto.CommandeRequest;
import itu.GreenField.model.Commande;
import itu.GreenField.service.CommandeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
@CrossOrigin(origins = "*")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    // -------------------------------------------------------
    // POST /api/commandes
    // Crée une nouvelle commande
    // -------------------------------------------------------
    @PostMapping
    public ResponseEntity<?> creerCommande(@RequestBody CommandeRequest req) {
        try {
            Commande commande = commandeService.creerCommande(req);
            return ResponseEntity.ok(commande);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // -------------------------------------------------------
    // GET /api/commandes
    // Liste toutes les commandes
    // -------------------------------------------------------
    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    // -------------------------------------------------------
    // GET /api/commandes/{id}
    // Détail d'une commande
    // -------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Integer id) {
        return commandeService.getCommandeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // -------------------------------------------------------
    // GET /api/commandes/client/{clientId}
    // Toutes les commandes d'un client
    // -------------------------------------------------------
    @GetMapping("/client/{clientId}")
    public ResponseEntity<?> getCommandesByClient(@PathVariable Integer clientId) {
        try {
            return ResponseEntity.ok(commandeService.getCommandesByClient(clientId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // -------------------------------------------------------
    // DELETE /api/commandes/{id}
    // Annule / supprime une commande
    // -------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> annulerCommande(@PathVariable Integer id) {
        return commandeService.annulerCommande(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
