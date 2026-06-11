package itu.GreenField.controller;

import itu.GreenField.model.EmployeeModel;
import itu.GreenField.model.Role;
import itu.GreenField.service.EmployeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // =========================
    // CREATE Employee
    // =========================
    @PostMapping
    public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employee) {

        if (!employeeService.createEmployee(employee)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(employee);
    }

    // =========================
    // GET ALL Employees
    // =========================
    @GetMapping
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // =========================
    // GET BY ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable Integer id) {
        EmployeeModel employee = employeeService.getEmployeeById(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }
}