package com.example.spring.project.management.model.projects.dto;

import com.example.spring.project.management.model.teams.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectRequest {


    private String projectNameR;
    private Team teamR;
}
