package com.example.spring.project.management.model.employees.dto;

import com.example.spring.project.management.model.employees.Subtype;
import com.example.spring.project.management.model.teams.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeRequest {

    private String nameR;
    private String surnameR;
    private String positionR;
    private LocalDate dateOfEmploymentR;
    private Subtype subtypeR;
    private Set<Team> teamsR;
}
