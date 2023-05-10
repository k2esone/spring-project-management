package com.example.spring.project.management.model.teams.repository;

import com.example.spring.project.management.model.teams.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
