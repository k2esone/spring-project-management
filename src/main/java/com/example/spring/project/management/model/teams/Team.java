package com.example.spring.project.management.model.teams;

import com.example.spring.project.management.model.employees.Employee;
import com.example.spring.project.management.model.projects.Project;
import com.example.spring.project.management.model.teams.teamsValidators.atMostOneManager.AtMostOneManager;
import com.example.spring.project.management.model.teams.teamsValidators.atMostTenDevelopers.AtMostTenDevelopers;
import com.example.spring.project.management.model.teams.teamsValidators.maxTwoProjects.MaxTwoProjects;
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
@MaxTwoProjects
@AtMostOneManager
@AtMostTenDevelopers
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "team")
    private Set<Project> projects;

    @ManyToMany(mappedBy = "teams")
    private Set<Employee> employees;
}
