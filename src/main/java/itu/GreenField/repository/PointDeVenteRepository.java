package itu.GreenField.repository;

import itu.GreenField.model.PointDeVenteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointDeVenteRepository extends JpaRepository<PointDeVenteModel, Integer> {
}
