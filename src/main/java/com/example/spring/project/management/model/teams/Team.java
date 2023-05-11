package com.example.spring.project.management.model.teams;

import com.example.spring.project.management.model.employees.Employee;
import com.example.spring.project.management.model.projects.Project;
import com.example.spring.project.management.model.teams.teamsValidators.atMostOneManager.AtMostOneManager;
import com.example.spring.project.management.model.teams.teamsValidators.atMostTenDevelopers.AtMostTenDevelopers;
import com.example.spring.project.management.model.teams.teamsValidators.maxTwoProjects.MaxTwoProjects;
import lombok.*;

import javax.persistence.*;
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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "team")
    private Set<Project> projects;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "teams")
    private Set<Employee> employees;
}
