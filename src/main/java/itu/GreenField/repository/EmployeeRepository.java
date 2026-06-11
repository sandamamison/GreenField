package itu.GreenField.repository;

import itu.GreenField.model.EmployeeModel;
import itu.GreenField.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {

    Optional<EmployeeModel> findByMail(String mail);

    boolean existsByMail(String mail);

    List<EmployeeModel> findByRole(Role role);

    List<EmployeeModel> findByEstActifTrue();

    List<EmployeeModel> findByPointDeVenteId(Integer id);
}