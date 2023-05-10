package com.example.spring.project.management.model.employees.controller;

import com.example.spring.project.management.model.employees.dto.CreateEmployeeRequest;
import com.example.spring.project.management.model.employees.dto.EmployeeResponse;
import com.example.spring.project.management.model.employees.dto.UpdateEmployeeResponse;
import com.example.spring.project.management.model.employees.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public EmployeeResponse createEmployee(@RequestBody CreateEmployeeRequest request) {
        log.info("employee addition has been triggered: {}", request);
        return employeeService.createEmployee(request);
    }

    @GetMapping()
    public List<EmployeeResponse> getEmployeesList() {
        log.info("someone asked for an employees list");
        return employeeService.getEmployeesList();
    }

    @GetMapping("/{employeeId}")
    public EmployeeResponse getEmployeeById(@PathVariable Long employeeId) {
        log.info("someone asked for an employee with id - {}", employeeId);
        return employeeService.getEmployeeById(employeeId);
    }

    @PatchMapping("/{employeeId}")
    public UpdateEmployeeResponse updateEmploye(@PathVariable Long employeeId, @RequestBody CreateEmployeeRequest request) {
        log.info("employee update with id - {} has been triggered, data: {}", employeeId, request);
        return employeeService.updateEmployee(employeeId, request);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId) {
        log.info("someone asked to delete an employee with id - {}", employeeId);
        employeeService.deleteEmployeeById(employeeId);
    }
}
