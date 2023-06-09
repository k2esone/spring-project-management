package com.example.spring.project.management.model.teams.service;

import com.example.spring.project.management.model.employees.service.EmployeeService;
import com.example.spring.project.management.model.teams.Team;
import com.example.spring.project.management.model.teams.dto.CreateTeamRequest;
import com.example.spring.project.management.model.teams.dto.TeamResponse;
import com.example.spring.project.management.model.teams.dto.UpdateTeamRequest;
import com.example.spring.project.management.model.teams.dto.UpdateTeamResponse;
import com.example.spring.project.management.model.teams.repository.TeamRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private EmployeeService employeeService;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    private TeamResponse mapTeamToTeamResponse(Team team) {
        return new TeamResponse(
                team.getId(),
                team.getProjects().stream().map(i -> i.getId()).collect(Collectors.toSet()),
                team.getEmployees().stream().map(i->i.getName()).collect(Collectors.toSet())
        );
    }

    public TeamResponse createTeam(CreateTeamRequest request) {
        Team team = Team.builder()
                .projects(request.getProjectsR())
                .employees(request.getEmployeesR())
                .build();
        teamRepository.save(team);

        return mapTeamToTeamResponse(team);
    }

    public List<TeamResponse> getTeamsList() {
        return teamRepository.findAll()
                .stream().map(team -> mapTeamToTeamResponse(team))
                .toList();
    }

    public TeamResponse getTeamById(Long teamId) {
        return teamRepository.findById(teamId)
                .stream().map(team -> mapTeamToTeamResponse(team))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Team not found, id: " + teamId));
    }

    private UpdateTeamResponse teamToTeamResponse(Team team) {
        return new UpdateTeamResponse(
                team.getId(),
                team.getProjects().stream().map(i->i.getId()).collect(Collectors.toSet()),
                team.getEmployees().stream().map(i->i.getName()).collect(Collectors.toSet())
        );
    }

    public UpdateTeamResponse updateTeam(Long teamId, UpdateTeamRequest request) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team not found, id: " + teamId));
        team.setProjects(request.getProjectsR());
        team.setEmployees(request.getEmployeesR());

        team = teamRepository.save(team);
        return teamToTeamResponse(team);
    }

    public void deleteTeamById(Long teamId) {
        try {
            teamRepository.deleteById(teamId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Team not found, id: " + teamId);
        }
    }
}
