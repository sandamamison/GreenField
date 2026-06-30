package itu.GreenField.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itu.GreenField.model.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Integer> {
    boolean existsByMail(String mail);
}
