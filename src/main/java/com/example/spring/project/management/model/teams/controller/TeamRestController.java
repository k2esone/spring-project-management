package com.example.spring.project.management.model.teams.controller;

import com.example.spring.project.management.model.teams.dto.CreateTeamRequest;
import com.example.spring.project.management.model.teams.dto.TeamResponse;
import com.example.spring.project.management.model.teams.dto.UpdateTeamRequest;
import com.example.spring.project.management.model.teams.dto.UpdateTeamResponse;
import com.example.spring.project.management.model.teams.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/team")
public class TeamRestController {
    private final TeamService teamService;

    public TeamRestController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public TeamResponse createTeam(@RequestBody CreateTeamRequest request) {
        log.info("team addition has been triggered: {}", request);
        return teamService.createTeam(request);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping()
    public List<TeamResponse> getTeamsList() {
        log.info("someone asks for a teams list");
        return teamService.getTeamsList();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{teamId}")
    public TeamResponse getTeamById(@PathVariable Long teamId) {
        log.info("someone asked for team with id - {}", teamId);
        return teamService.getTeamById(teamId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{teamId}")
    public UpdateTeamResponse updateTeam(@PathVariable Long teamId, @RequestBody UpdateTeamRequest request) {
        log.info("team update with id - {} has been triggered, data: {}", teamId, request);
        return teamService.updateTeam(teamId, request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{teamId}")
    public void deleteTeamById(@PathVariable Long teamId) {
        log.info("someone ask to delete team with id - {}", teamId);
        teamService.deleteTeamById(teamId);
    }

}
