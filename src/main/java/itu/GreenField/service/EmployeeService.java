package itu.GreenField.service;

import itu.GreenField.model.EmployeeModel;
import itu.GreenField.model.Role;
import itu.GreenField.repository.EmployeeRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean createEmployee(EmployeeModel employee) {

        if (employeeRepository.existsByMail(employee.getMail())) {
            return false;
        }

        employeeRepository.save(employee);
        return true;
    }

    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeModel getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public EmployeeModel getByMail(String mail) {
        return employeeRepository.findByMail(mail).orElse(null);
    }

    public List<EmployeeModel> getByRole(Role role) {
        return employeeRepository.findByRole(role);
    }

    public List<EmployeeModel> getActiveEmployees() {
        return employeeRepository.findByEstActifTrue();
    }

    public List<EmployeeModel> getByPointDeVente(Integer id) {
        return employeeRepository.findByPointDeVenteId(id);
    }

    public boolean updateEmployee(Integer id, EmployeeModel employee) {
        if (!employeeRepository.existsById(id)) {
            return false;
        }
        employee.setId(id);
        employeeRepository.save(employee);
        return true;
    }

    public boolean deleteEmployee(Integer id) {
        if (!employeeRepository.existsById(id)) {
            return false;
        }
        employeeRepository.deleteById(id);
        return true;
    }
}