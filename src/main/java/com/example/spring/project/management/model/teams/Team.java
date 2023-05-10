package com.example.spring.project.management.model.teams;

import com.example.spring.project.management.model.employees.Employee;
import com.example.spring.project.management.model.projects.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "team")
    private Set<Project> projects;

    @ManyToMany(mappedBy = "teams")
    private Set<Employee> employees;
}
