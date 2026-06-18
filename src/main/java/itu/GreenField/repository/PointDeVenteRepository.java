package itu.GreenField.repository;

import itu.GreenField.model.PointDeVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointDeVenteRepository extends JpaRepository<PointDeVente, Integer> {
}
