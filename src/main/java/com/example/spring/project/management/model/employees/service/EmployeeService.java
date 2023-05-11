package com.example.spring.project.management.model.employees.service;

import com.example.spring.project.management.model.employees.Employee;
import com.example.spring.project.management.model.employees.dto.CreateEmployeeRequest;
import com.example.spring.project.management.model.employees.dto.EmployeeResponse;
import com.example.spring.project.management.model.employees.dto.UpdateEmployeeResponse;
import com.example.spring.project.management.model.employees.repository.EmployeeRepository;
import com.example.spring.project.management.model.teams.Team;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private EmployeeResponse mapEmployeeToEmployeeResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getSurname(),
                employee.getPosition(),
                employee.getDateOfEmployment(),
                employee.getSubtype(),
                employee.getTeams().stream().map(Team::getId).collect(Collectors.toSet())
        );
    }

    public EmployeeResponse createEmployee(CreateEmployeeRequest request) {
        Employee employee = Employee.builder()
                .name(request.getNameR())
                .surname(request.getSurnameR())
                .position(request.getPositionR())
                .dateOfEmployment(request.getDateOfEmploymentR())
                .subtype(request.getSubtypeR())
                .teams(request.getTeamsR())
                .build();

        employeeRepository.save(employee);

        return mapEmployeeToEmployeeResponse(employee);
    }


    public List<EmployeeResponse> getEmployeesList() {
        return employeeRepository.findAll()
                .stream().map(employee -> mapEmployeeToEmployeeResponse(employee))
                .toList();
    }

    public EmployeeResponse getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .stream().map(employee -> mapEmployeeToEmployeeResponse(employee))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Employee not found, id: " + employeeId));
    }

    private UpdateEmployeeResponse employeeToEmployeeResponse(Employee employee) {
        return new UpdateEmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getSurname(),
                employee.getPosition(),
                employee.getDateOfEmployment(),
                employee.getSubtype(),
                employee.getTeams().stream().map(Team::getId).collect(Collectors.toSet())
        );
    }

    public UpdateEmployeeResponse updateEmployee(Long employeeId, CreateEmployeeRequest request) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found, id: " + employeeId));
        employee.setSurname(request.getSurnameR());
        employee.setPosition(request.getPositionR());
        employee.setSubtype(request.getSubtypeR());
        employee.setTeams(request.getTeamsR());

        employee = employeeRepository.save(employee);

        return employeeToEmployeeResponse(employee);

    }

    public void deleteEmployeeById(Long employeeId) {
        try {
            employeeRepository.deleteById(employeeId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Employee not found, id: " + employeeId);
        }
    }
}
