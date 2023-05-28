package com.example.spring.project.management.model.projects.service;

import com.example.spring.project.management.model.employees.dto.UpdateEmployeeRequest;
import com.example.spring.project.management.model.projects.Project;
import com.example.spring.project.management.model.projects.dto.CreateProjectRequest;
import com.example.spring.project.management.model.projects.dto.ProjectResponse;
import com.example.spring.project.management.model.projects.dto.UpdateProjectRequest;
import com.example.spring.project.management.model.projects.dto.UpdateProjectResponse;
import com.example.spring.project.management.model.projects.repository.ProjectRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    private ProjectResponse mapProjectToProjectResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getProjectName(),
                project.getTeam().getId()
        );
    }

    public ProjectResponse createProject(CreateProjectRequest request) {
        Project project = Project.builder()
                .projectName(request.getProjectNameR())
                .team(request.getTeamR())
                .build();
        projectRepository.save(project);

        return mapProjectToProjectResponse(project);
    }

    public List<ProjectResponse> getProjectsList() {
        return projectRepository.findAll()
                .stream().map(project -> mapProjectToProjectResponse(project))
                .toList();
    }

    public ProjectResponse getProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .stream().map(project -> mapProjectToProjectResponse(project))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Project not found, id: " + projectId));
    }

    private UpdateProjectResponse projectToProjectResponse(Project project) {
        return new UpdateProjectResponse(
                project.getId(),
                project.getProjectName(),
                project.getTeam().getId()
        );
    }

    public UpdateProjectResponse updateProject(Long projectId, UpdateProjectRequest request) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project not found, id: " + projectId));
        project.setTeam(request.getTeamR());

        project = projectRepository.save(project);

        return projectToProjectResponse(project);

    }

    public void deleteProjectById(Long projectId) {
        try {
            projectRepository.deleteById(projectId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Project not found, id: " + projectId);
        }
    }
}
