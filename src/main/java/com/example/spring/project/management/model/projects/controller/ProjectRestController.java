package com.example.spring.project.management.model.projects.controller;

import com.example.spring.project.management.model.projects.dto.CreateProjectRequest;
import com.example.spring.project.management.model.projects.dto.ProjectResponse;
import com.example.spring.project.management.model.projects.dto.UpdateProjectResponse;
import com.example.spring.project.management.model.projects.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectRestController {
    private final ProjectService projectService;

    public ProjectRestController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ProjectResponse createProject(@RequestBody CreateProjectRequest request) {
        log.info("project addition has been triggered: {}", request);
        return projectService.createProject(request);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping()
    public List<ProjectResponse> getProjectsList() {
        log.info("someone asked for a projects list");
        return projectService.getProjectsList();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{projectId}")
    public ProjectResponse getProjectById(@PathVariable Long projectId) {
        log.info("someone asked for project with id - {}", projectId);
        return projectService.getProjectById(projectId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{projectId}")
    public UpdateProjectResponse updateProject(@PathVariable Long projectId, @RequestBody CreateProjectRequest request) {
        log.info("project update with id - {} has been triggered, data: {}", projectId, request);
        return projectService.updateProject(projectId, request);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{projectId}")
    public void deleteProjectById(Long projectId) {
        log.info("someone ask to delete project with id - {}", projectId);
        projectService.deleteProjectById(projectId);
    }
}
