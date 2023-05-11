package com.example.spring.project.management.model.projects.dto;

import com.example.spring.project.management.model.teams.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {

    private Long idR;

    private String projectNameR;
    private Long teamRId;
}
