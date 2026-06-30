package itu.GreenField.repository;

import itu.GreenField.model.CommandeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<CommandeModel, Integer> {
    List<CommandeModel> findByClientId(Integer clientId);
}
