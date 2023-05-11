package com.example.spring.project.management.model.teams.dto;

import com.example.spring.project.management.model.employees.Employee;
import com.example.spring.project.management.model.projects.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTeamResponse {
    private Long id;

    private Set<Long> projectsR;
    private Set<String> employeesR;
}
