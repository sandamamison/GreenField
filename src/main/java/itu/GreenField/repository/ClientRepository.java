package itu.GreenField.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itu.GreenField.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    boolean existsByMail(String mail);
}
