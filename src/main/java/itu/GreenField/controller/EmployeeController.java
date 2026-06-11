package itu.GreenField.controller;

import itu.GreenField.model.EmployeeModel;
import itu.GreenField.model.Role;
import itu.GreenField.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // =========================
    // CREATE Employee
    // =========================
    @PostMapping
    public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employee) {

        if (employeeRepository.existsByMail(employee.getMail())) {
            return ResponseEntity.badRequest().build();
        }

        EmployeeModel saved = employeeRepository.save(employee);
        return ResponseEntity.ok(saved);
    }

    // =========================
    // GET ALL Employees
    // =========================
    @GetMapping
    public List<EmployeeModel> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable Integer id) {
        Optional<EmployeeModel> employee = employeeRepository.findById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // =========================
    // GET BY EMAIL
    // =========================
    @GetMapping("/email/{mail}")
    public ResponseEntity<EmployeeModel> getByMail(@PathVariable String mail) {
        return employeeRepository.findByMail(mail)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // =========================
    // GET BY ROLE
    // =========================
    @GetMapping("/role/{role}")
    public List<EmployeeModel> getByRole(@PathVariable Role role) {
        return employeeRepository.findByRole(role);
    }

    // =========================
    // GET ACTIVE EMPLOYEES
    // =========================
    @GetMapping("/active")
    public List<EmployeeModel> getActiveEmployees() {
        return employeeRepository.findByEstActifTrue();
    }

    // =========================
    // GET BY POINT DE VENTE
    // =========================
    @GetMapping("/pointdevente/{id}")
    public List<EmployeeModel> getByPointDeVente(@PathVariable Integer id) {
        return employeeRepository.findByPointDeVenteId(id);
    }

}